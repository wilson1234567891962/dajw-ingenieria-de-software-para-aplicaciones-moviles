package com.co.analytics

import com.co.analytics.dto.DataBase
import com.google.firebase.FirebaseApp
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

internal lateinit var fireBaseDatabase: FirebaseApp

fun getInstanceDataBase(): DatabaseReference {
    val fireBaseDataBase = FirebaseDatabase.getInstance()
    return fireBaseDataBase.reference.child("User")
}

fun insertDataFireBase(reference: DatabaseReference, device: DataBase) {
    reference.push().setValue(device)
}


