package com.touchcard.testax.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.touchcard.testax.R
import com.touchcard.testax.data.*
import com.touchcard.testax.data.models.ApiResponse
import com.touchcard.testax.ui.activity.CellClickListener
import kotlinx.android.synthetic.main.item_recycler.view.*

class UsersAdapter(private val list: List<ApiResponse.Result>, val listener: CellClickListener) :
    RecyclerView.Adapter<UsersAdapter.UserHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_recycler, parent, false)
        return UserHolder(view)
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        val item = list[position]
        holder.itemView.apply {
            name.text = "${item.mName.mFirst} ${item.mName.mLast}"
            Glide.with(imageView).load(item.mPicture.mThumbnail).circleCrop().into(imageView)
            setOnClickListener {
                listener.onCellClickListener(bundleOf(
                    Pair(PHOTO, item.mPicture.mLarge),
                    Pair(FULL_NAME, name.text),
                    Pair(GENDER, item.mGender),
                    Pair(BIRTHDAY, item.mDob.mDate),
                    Pair(PHONE, item.mPhone),
                    Pair(EMAIL, item.mEmail)
                ))
            }
        }

    }

    override fun getItemCount() = list.size

    class UserHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}