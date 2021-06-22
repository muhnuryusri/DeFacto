package com.application.defacto.menu.law.fragment.keputusan_presiden

import androidx.lifecycle.ViewModel
import com.application.defacto.data.local.entity.law.LawEntity
import com.application.defacto.data.remote.CatalogueRepository
import com.application.defacto.utils.DataDummy

class KeputusanPresidenViewModel(private val catalogueRepository: CatalogueRepository): ViewModel() {
    fun getKeputusanPresidenList() = catalogueRepository.getLaw()
}