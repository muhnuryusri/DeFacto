package com.application.defacto.menu.law.fragment.undang_undang

import androidx.lifecycle.ViewModel
import com.application.defacto.data.local.entity.law.LawEntity
import com.application.defacto.data.remote.CatalogueRepository
import com.application.defacto.utils.DataDummy

class UndangUndangViewModel(private val catalogueRepository: CatalogueRepository): ViewModel() {
    fun getUndangUndangList() = catalogueRepository.getLaw()
}