package com.example.musicplayer.exoplayer

import android.content.Context
import android.media.session.PlaybackState
import android.support.v4.media.MediaMetadataCompat
import android.support.v4.media.session.MediaControllerCompat
import android.support.v4.media.session.PlaybackStateCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.musicplayer.other.Event
import com.example.musicplayer.other.Resource

class MusicServiceConnection(context: Context) {

    private val _isConnected = MutableLiveData<Event<Resource<Boolean>>>()
    val isConnected: LiveData<Event<Resource<Boolean>>> = _isConnected

    private val _networkError = MutableLiveData<Event<Resource<Boolean>>>()
    val networkError: LiveData<Event<Resource<Boolean>>> = _networkError

    private val _playbackState = MutableLiveData<PlaybackStateCompat?>()
    val playbackState: LiveData<PlaybackStateCompat?> = _playbackState

    private val _curPlayingSong = MutableLiveData<MediaMetadataCompat>()
    val curPlayingSong: LiveData<MediaMetadataCompat> = _curPlayingSong

    lateinit var mediaController: MediaControllerCompat

    val transportControls: MediaControllerCompat.TransportControls
        get() = mediaController.transportControls
}