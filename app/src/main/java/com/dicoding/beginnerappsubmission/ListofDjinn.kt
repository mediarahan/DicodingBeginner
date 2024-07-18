package com.dicoding.beginnerappsubmission

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ListofDjinn(
    val name: String?,
    val description: String?,
    val tagline: String?,
    val location: String?,
    val photo: Int
) : Parcelable

