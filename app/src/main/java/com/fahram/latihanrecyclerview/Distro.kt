package com.fahram.latihanrecyclerview

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Distro(
    var name: String,
    var origin: String,
    var base: String,
    var logo: Int,
    var desc: String
) : Parcelable