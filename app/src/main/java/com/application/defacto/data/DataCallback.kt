package com.application.defacto.data

import com.application.defacto.data.local.entity.law.LawEntity

interface DataCallback {
    fun onItemClicked(data: LawEntity)
}