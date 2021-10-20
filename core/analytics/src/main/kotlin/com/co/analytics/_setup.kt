package com.co.analytics

import android.app.Application
import com.google.firebase.FirebaseApp
import com.google.firebase.analytics.FirebaseAnalytics

fun Application.setupFireBase() {
    fireBaseDatabase = FirebaseApp.initializeApp(this)!!
    firebaseTracker = FirebaseAnalytics.getInstance(this)
}