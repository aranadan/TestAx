package com.touchcard.testax.ui.activity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Telephony
import android.util.Log
import com.bumptech.glide.Glide
import com.touchcard.testax.R
import com.touchcard.testax.data.*
import kotlinx.android.synthetic.main.user_detail.*
import java.text.SimpleDateFormat
import java.util.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_detail)

        val bundle = intent.getBundleExtra(USER_POSITION)
        bundle?.let {
            Glide.with(this).load(it.get(PHOTO)).circleCrop().into(userPhoto)
            fullName.text = it.get(FULL_NAME).toString()
            gender.text = it.get(GENDER).toString()
            birth.text = "Date of birth(${parseDate(it.get(BIRTHDAY).toString())})"
            phone.setText(it.get(PHONE).toString())
            email.setText(it.get(EMAIL).toString())
        }

        phone.setOnClickListener {
            Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:${phone.text}")
                startActivity(this)
            }
        }
    }

    private fun parseDate(date: String): String {
        val userFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX", Locale.getDefault())
        val mDate = inputFormat.parse(date)

        return userFormat.format(mDate!!)
    }
}