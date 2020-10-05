package com.touchcard.testax.data.repository

import com.touchcard.testax.data.api.ApiService

internal class Repository(private val apiHelper: ApiService) : IRepository {

    override suspend fun getUsers() = apiHelper.getUsers()
}