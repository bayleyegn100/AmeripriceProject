package com.yedebkid.ameriprisecodechallenge.data.remote

import com.yedebkid.ameriprisecodechallenge.data.base.BaseApiModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("current.json")
    suspend fun getWeatherData(@Query("q") cityName: String, @Query("key") apiKey: String):
            Response<BaseApiModel<com.yedebkid.ameriprisecodechallenge.data.Response>>
}