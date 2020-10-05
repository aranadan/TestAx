package com.touchcard.testax.ui.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.touchcard.testax.data.models.Response
import com.touchcard.testax.data.module.getRepository
import com.touchcard.testax.data.repository.IRepository
import kotlinx.coroutines.Dispatchers


class MainViewModel : ViewModel() {
    private val repository: IRepository = getRepository()

    fun getUsers() = liveData(Dispatchers.IO) {
        emit(Response.Loading(true))
        try {
            emit(Response.Success(repository.getUsers()))
        } catch (e: Exception) {
            emit(Response.Failure(e.message!!))
            Log.e("TAG", e.printStackTrace().toString())
        }
        emit(Response.Loading(false))
    }
}