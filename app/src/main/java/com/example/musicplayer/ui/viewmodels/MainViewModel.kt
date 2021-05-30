package com.example.musicplayer.ui.viewmodels

import android.support.v4.media.MediaBrowserCompat
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import com.example.musicplayer.data.entities.Song
import com.example.musicplayer.exoplayer.MusicServiceConnection
import com.example.musicplayer.other.Constants.MEDIA_ROOT_ID
import com.example.musicplayer.other.Resource

class MainViewModel @ViewModelInject constructor(

    private val musicServiceConnection: MusicServiceConnection
) {

    private val _mediaItems = MutableLiveData<Resource<List<Song>>>()

    private val mediaItems: MutableLiveData<Resource<List<Song>>> = _mediaItems


    val isConnected = musicServiceConnection.isConnected

    val networkError = musicServiceConnection.networkError

    val curPlayingSong = musicServiceConnection.curPlayingSong

    val playbackState = musicServiceConnection.playbackState

    init {
        _mediaItems.postValue(Resource.loading(null))
        musicServiceConnection.subscribe(
            MEDIA_ROOT_ID,
            object : MediaBrowserCompat.SubscriptionCallback() {
                override fun onChildrenLoaded(
                    parentId: String,
                    children: MutableList<MediaBrowserCompat.MediaItem>
                ) {
                    super.onChildrenLoaded(parentId, children)
                    val items = children.map {
                        Song(
                            it.mediaId!!,
                            it.description.title.toString(),
                            it.description.subtitle.toString(),
                            it.description.mediaUri.toString(),
                            it.description.iconUri.toString()

                        )
                    }
                }
            })
    }


}


}