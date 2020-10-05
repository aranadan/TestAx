package com.touchcard.testax.data.api

import com.touchcard.testax.data.models.ApiResponse
import retrofit2.http.GET

interface ApiService {
    @GET("api/?results=20")
   suspend fun getUsers(): ApiResponse
}
