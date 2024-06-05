package com.example.dicodingsubmission

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Crew(
    val name: String,
    val description: String,
    val photo: Int,
    val photoDetail: Int,
    val birthday: String,
    val age:String,
    val bounty: String,
    val va: String,
) : Parcelable
