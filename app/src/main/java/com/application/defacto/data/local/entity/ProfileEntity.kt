package com.application.defacto.data.local.entity

import com.application.defacto.data.local.entity.law.LawEntity

data class ProfileEntity (
    val id: String?,
    val photo: String?,
    val nama: String?,
    val email: String?,
    val bookmark: ArrayList<List<LawEntity>>
)