package com.yedebkid.ameriprisecodechallenge.data.base

data class BaseApiModel<T> (
    val StatusCode: Int = -1,
    val Message: String?,
    val Errors: List<String>?,
    val Data: T? = null
)