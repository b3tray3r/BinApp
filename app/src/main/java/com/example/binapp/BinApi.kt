package com.example.binapp

import io.reactivex.rxjava3.core.Single
import retrofit2.Call
import retrofit2.http.GET

interface BinApi {

    @GET("./45717360")
    fun getBinList() : Call<BinListResponse>

}