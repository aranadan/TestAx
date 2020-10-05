package com.touchcard.testax.data.module

import com.touchcard.testax.data.api.RetrofitBuilder
import com.touchcard.testax.data.repository.Repository

private fun getApiService() = RetrofitBuilder.apiService

internal fun getRepository() = Repository(getApiService())