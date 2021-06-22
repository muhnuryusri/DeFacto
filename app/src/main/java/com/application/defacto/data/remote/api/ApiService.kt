package com.application.defacto.data.remote.api

import com.application.defacto.data.remote.response.law.LawDetailResponse
import com.application.defacto.data.remote.response.law.LawResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Streaming

interface ApiService {

    @GET("content/all")
    fun getLaw(
    ): Call<List<LawResponse>>

    @GET("content/{id}")
    fun getLawDetail(
        @Path("id") id: Int,
    ): Call<LawDetailResponse>

/*    @Streaming
    @GET("constitution/2020uu011.pdf")
    suspend fun downloadPdf(
    ): Call<LawDetailResponse>*/
}