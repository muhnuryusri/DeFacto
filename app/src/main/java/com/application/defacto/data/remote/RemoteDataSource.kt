package com.application.defacto.data.remote

import com.application.defacto.data.remote.api.ApiConfig
import com.application.defacto.data.remote.response.law.LawDetailResponse
import com.application.defacto.data.remote.response.law.LawResponse
import com.application.defacto.utils.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource {
    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource()
            }
    }

    fun getLaws(callback: LoadLawCallback) {
        EspressoIdlingResource.increment()
        val client = ApiConfig.getApiService().getLaw()
        client.enqueue(object : Callback<List<LawResponse>> {
            override fun onResponse(call: Call<List<LawResponse>>, response: Response<List<LawResponse>>) {
                callback.onLawLoaded(response.body())
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<List<LawResponse>>, t: Throwable) {
                EspressoIdlingResource.decrement()
            }
        })
    }

    fun getLawDetail(callback: LoadDetailLawCallback, lawId: Int) {
        EspressoIdlingResource.increment()
        val client = ApiConfig.getApiService().getLawDetail(lawId)
        client.enqueue(object : Callback<LawDetailResponse> {
            override fun onResponse(call: Call<LawDetailResponse>, response: Response<LawDetailResponse>) {
                callback.onLawDetailLoaded(response.body())
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<LawDetailResponse>, t: Throwable) {
                EspressoIdlingResource.decrement()
            }
        })
    }

    interface LoadLawCallback {
        fun onLawLoaded(law: List<LawResponse>?)
    }

    interface LoadDetailLawCallback {
        fun onLawDetailLoaded(lawDetail : LawDetailResponse?)
    }
}