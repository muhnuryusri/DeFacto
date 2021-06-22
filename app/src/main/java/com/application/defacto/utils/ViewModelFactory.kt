package com.application.defacto.utils

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.application.defacto.data.remote.CatalogueRepository
import com.application.defacto.di.Injection
import com.application.defacto.menu.law.fragment.keputusan_presiden.KeputusanPresidenViewModel
import com.application.defacto.menu.law.fragment.peraturan_pemerintah.PeraturanPemerintahViewModel
import com.application.defacto.menu.law.fragment.peraturan_presiden.PeraturanPresidenViewModel
import com.application.defacto.menu.law.fragment.undang_undang.UndangUndangViewModel
import com.application.defacto.menu.ui.detail.DetailViewModel

class ViewModelFactory private constructor(private val catalogueRepository: CatalogueRepository) : ViewModelProvider.NewInstanceFactory(){
    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
                instance ?: synchronized(this) {
                    instance ?: ViewModelFactory(Injection.provideRepository(context)).apply {
                        instance = this
                    }
                }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(UndangUndangViewModel::class.java) -> {
                UndangUndangViewModel(catalogueRepository) as T
            }
            modelClass.isAssignableFrom(PeraturanPemerintahViewModel::class.java) -> {
                PeraturanPemerintahViewModel(catalogueRepository) as T
            }
            modelClass.isAssignableFrom(PeraturanPresidenViewModel::class.java) -> {
                PeraturanPresidenViewModel(catalogueRepository) as T
            }
            modelClass.isAssignableFrom(KeputusanPresidenViewModel::class.java) -> {
                KeputusanPresidenViewModel(catalogueRepository) as T
            }
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> {
                DetailViewModel(catalogueRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class :" + modelClass.name)
        }
    }
}