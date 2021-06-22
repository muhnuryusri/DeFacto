package com.application.defacto.data.remote

import androidx.lifecycle.LiveData
import com.application.defacto.data.local.entity.law.LawDetailEntity
import com.application.defacto.data.local.entity.law.LawEntity

interface CatalogueDataSource {
    fun getLaw(): LiveData<List<LawEntity>>
    fun getDetailLaw(lawId: Int): LiveData<LawDetailEntity>
}