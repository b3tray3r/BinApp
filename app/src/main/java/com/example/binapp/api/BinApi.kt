package com.example.binapp.api

import com.example.binapp.json.BinInfoItem
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface BinApi {

    @GET("{binId}")
    fun getId(@Path("binId") binId: String): Single<BinInfoItem>

}