package com.yedebkid.ameriprisecodechallenge.data.base

import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

open class BaseRepository {

    protected suspend inline fun <reified T> handleApiResponse(response: Response<T>): T? {
        return if (response.isSuccessful) response.body()
        else {
            var parsed: T? = null
            withContext(Dispatchers.IO) {
                parsed = Gson().fromJson<T>(
                    response.errorBody()?.string(),
                    T::class.java
                )
            }
            parsed
        }
    }

    protected inline fun <reified T> handleException(exception: Exception): BaseApiModel<T> {
        when (exception) {
            is UnknownHostException -> {
                return BaseApiModel(
                    404,
                    "No internet connection.",
                    listOf(),
                    null
                )
            }
            is SocketTimeoutException -> {
                return BaseApiModel(
                    501,
                    "Connection timeout.",
                    listOf(),
                    null
                )
            }
            is ConnectException -> {
                return BaseApiModel(
                    501,
                    "Connection refused.",
                    listOf(),
                    null
                )
            }
            else -> {
                return BaseApiModel(
                    501,
                    "Something went wrong!",
                    listOf(),
                    null
                )
            }
        }
    }
}