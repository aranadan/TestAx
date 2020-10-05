package com.touchcard.testax.data.models

sealed class Response<out T : Any> {
    data class Success(val data: ApiResponse) : Response<ApiResponse>()
    data class Failure(val message: String) : Response<String>()
    data class Loading(val loading: Boolean) : Response<Nothing>()
}