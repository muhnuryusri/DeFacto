package com.application.defacto.menu.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.application.defacto.data.local.entity.law.LawDetailEntity
import com.application.defacto.data.local.entity.law.LawEntity
import com.application.defacto.data.remote.CatalogueRepository
import com.application.defacto.utils.DataDummy

class DetailViewModel(private val catalogueRepository: CatalogueRepository): ViewModel() {
    fun getSelectedLaw(lawId: Int): LiveData<LawDetailEntity> = catalogueRepository.getDetailLaw(lawId)
}