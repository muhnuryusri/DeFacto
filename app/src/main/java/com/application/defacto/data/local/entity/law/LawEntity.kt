package com.application.defacto.data.local.entity.law

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LawEntity (
    val id: Int?,
    val status: String?,
    val nomor: Int?,
    val judul: String?,
    val tanggal_penetapan: String?
) : Parcelable