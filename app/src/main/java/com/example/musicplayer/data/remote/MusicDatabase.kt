package com.example.musicplayer.data.remote

import com.example.musicplayer.other.Constants.SONG_COLLECTION
import com.google.firebase.firestore.FirebaseFirestore

class MusicDatabase {

    private val firestore = FirebaseFirestore.getInstance()
    private val songCollecton = firestore.collection(SONG_COLLECTION)


    suspend fun getAllSongs(){}
}