package com.application.defacto.di

import android.content.Context
import com.application.defacto.data.remote.CatalogueRepository
import com.application.defacto.data.remote.RemoteDataSource

object Injection {
    fun provideRepository(context: Context): CatalogueRepository {
        val remoteDataSource = RemoteDataSource.getInstance()
        return CatalogueRepository.getInstance(remoteDataSource)
    }
}