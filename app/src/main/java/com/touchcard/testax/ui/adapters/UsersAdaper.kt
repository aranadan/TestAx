package com.touchcard.testax.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.touchcard.testax.R
import com.touchcard.testax.data.models.ApiResponse
import kotlinx.android.synthetic.main.item_recycler.view.*

class UsersAdapter(private val list: List<ApiResponse.Result>) :
    RecyclerView.Adapter<UsersAdapter.UserHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_recycler, parent, false)
        return UserHolder(view)
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    class UserHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("SetTextI18n")
        fun bind(item: ApiResponse.Result) {
            itemView.name.text = "${item.mName.mFirst} ${item.mName.mLast}"
            Glide.with(itemView.imageView).load(item.mPicture.mThumbnail).circleCrop().into(itemView.imageView)
        }
    }
}