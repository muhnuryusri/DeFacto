package com.application.defacto.data.remote.response.law

import com.google.gson.annotations.SerializedName

data class LawResponse(

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("deletedAt")
	val status: String? = null,

	@field:SerializedName("nomor_peraturan")
	val nomorPeraturan: Int? = null,

	@field:SerializedName("judul")
	val judul: String? = null,

	@field:SerializedName("tanggal_penetapan")
	val tanggalPenetapan: String? = null,
)
