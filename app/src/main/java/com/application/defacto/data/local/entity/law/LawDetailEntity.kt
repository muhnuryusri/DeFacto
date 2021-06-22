package com.application.defacto.data.local.entity.law

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LawDetailEntity (
    val id: Int?,
    val nomor: Int?,
    val judul: String?,
    val jenis: String?,
    val tempat: String?,
    val tanggal_penetapan: String?,
    val tanggal_pengundangan: String?,
    val bidang: String?,
    val bahasa: String?,
    val pemrakarsa: String?,
    val penandatangan: String?,
    val subjek: String?,
    val simplifikasi: String?,
    val pdf: String?,
    val status: String?
) : Parcelable