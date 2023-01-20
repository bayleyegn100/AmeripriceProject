package com.yedebkid.ameriprisecodechallenge.data

import com.yedebkid.ameriprisecodechallenge.data.base.BaseApiModel
import com.yedebkid.ameriprisecodechallenge.data.base.BaseRepository
import com.yedebkid.ameriprisecodechallenge.data.remote.ApiService
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class AppRepository @Inject constructor(private val apiService: ApiService): BaseRepository() {

    suspend fun getWeatherData(): BaseApiModel<Response>? {
        return try {
            handleApiResponse(apiService.getWeatherData("visakhapatnam", "520916eb3f46442ca1c12926221402"))
        } catch (ex: java.lang.Exception) {
            handleException(ex)
        }
    }
}