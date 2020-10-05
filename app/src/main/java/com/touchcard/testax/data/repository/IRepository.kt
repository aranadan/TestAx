package com.touchcard.testax.data.repository

import com.touchcard.testax.data.models.ApiResponse

interface IRepository {

   suspend fun getUsers(): ApiResponse
}
