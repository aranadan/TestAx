package com.touchcard.testax.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.touchcard.testax.R
import com.touchcard.testax.ui.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initLiveData()
    }

    private fun initLiveData() {
        val viewModel by lazy { ViewModelProvider(this).get(MainViewModel::class.java) }

        viewModel.getUsers().observe(this) {
            Log.i("TAG", it.toString())
        }
    }
}