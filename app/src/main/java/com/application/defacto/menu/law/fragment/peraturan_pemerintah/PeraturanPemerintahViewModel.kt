package com.application.defacto.menu.law.fragment.peraturan_pemerintah

import androidx.lifecycle.ViewModel
import com.application.defacto.data.local.entity.law.LawEntity
import com.application.defacto.data.remote.CatalogueRepository
import com.application.defacto.utils.DataDummy

class PeraturanPemerintahViewModel(private val catalogueRepository: CatalogueRepository): ViewModel() {
    fun getPeraturanPemerintahList() = catalogueRepository.getLaw()
}