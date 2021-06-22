package com.application.defacto.data.remote.response.law

import com.google.gson.annotations.SerializedName

data class LawDetailResponse(

        @field:SerializedName("id")
        val id: Int? = null,

        @field:SerializedName("nama_file")
        val namaFile: String? = null,

        @field:SerializedName("judul")
        val judul: String? = null,

        @field:SerializedName("nomor_peraturan")
        val nomorPeraturan: Int? = null,

        @field:SerializedName("jenis_peraturan")
        val jenisPeraturan: String? = null,

        @field:SerializedName("tempat_penetapan")
        val tempatPenetapan: String? = null,

        @field:SerializedName("tanggal_pengundagan")
        val tanggalPengundagan: String? = null,

        @field:SerializedName("bidang_hukum")
        val bidangHukum: String? = null,

        @field:SerializedName("tanggal_penetapan")
        val tanggalPenetapan: String? = null,

        @field:SerializedName("bahasa")
        val bahasa: String? = null,

        @field:SerializedName("pemrakasa")
        val pemrakasa: String? = null,

        @field:SerializedName("penandatangan")
        val penandatangan: String? = null,

        @field:SerializedName("subjek")
        val subjek: String? = null,

        @field:SerializedName("description")
        val description: String? = null,

        @field:SerializedName("createdAt")
        val createdAt: String? = null,

        @field:SerializedName("updatedAt")
        val updatedAt: String? = null,

        @field:SerializedName("deletedAt")
        val deletedAt: String? = null
)
