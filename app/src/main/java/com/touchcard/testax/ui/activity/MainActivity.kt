package com.touchcard.testax.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.touchcard.testax.R
import com.touchcard.testax.data.USER_POSITION
import com.touchcard.testax.data.models.Response
import com.touchcard.testax.ui.adapters.UsersAdapter
import com.touchcard.testax.ui.viewModel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), CellClickListener {
    private lateinit var snackBar: Snackbar

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel by lazy { ViewModelProvider(this).get(MainViewModel::class.java) }
        snackBar = Snackbar.make(
            recyclerUsers,
            getString(R.string.failed_load_data),
            Snackbar.LENGTH_INDEFINITE
        )
        snackBar.setAction("repeat") { initLiveData(viewModel) }
        recyclerUsers.setHasFixedSize(true)
        initLiveData(viewModel)

    }

    private fun initLiveData(viewModel: MainViewModel) {

        viewModel.getUsers().observe(this) {
            when (it) {
                is Response.Success -> recyclerUsers.adapter =
                    UsersAdapter(it.data.mResults, this)
                is Response.Failure -> snackBar.show()
                is Response.Loading -> {
                    visibilityProgressBar(it.loading)
                }
            }
        }
    }

    override fun onCellClickListener(userInfo: Bundle) {
        Intent(applicationContext, DetailActivity::class.java).apply {
            putExtra(USER_POSITION, userInfo)
            startActivity(this)
        }
    }

    private fun visibilityProgressBar(status: Boolean) {
        when (status) {
            true -> progressBar.visibility = View.VISIBLE
            false -> {
                progressBar.visibility = View.INVISIBLE
            }
        }
    }
}

interface CellClickListener {
    fun onCellClickListener(userInfo: Bundle)
}