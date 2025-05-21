package com.example.androidform.Model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Assessment(
    val nama: String,
    val nim: String,
    val semester: String,
    val device: String,
    val os: String,
    val versiOs: String,
    val ram: String,
    val cpu: String,
    val deployment: String,
    val merkHp: String,
    val osHpDetail: String,
    val ukuranHp: String,
    val penggunaanInternet: String,
    val instalasiAndroidStudio: String,
    val versiAndroidStudio: String
) : Parcelable
