package com.touchcard.testax.data.models


import com.google.gson.annotations.SerializedName


data class ApiResponse(
    @SerializedName("results")
    val mResults: List<Result>
) {
    data class Result(
        @SerializedName("cell")
        val mCell: String,
        @SerializedName("dob")
        val mDob: Dob,
        @SerializedName("email")
        val mEmail: String,
        @SerializedName("gender")
        val mGender: String,
        @SerializedName("name")
        val mName: Name,
        @SerializedName("phone")
        val mPhone: String,
        @SerializedName("picture")
        val mPicture: Picture
    ) {
        data class Dob(
            @SerializedName("age")
            val mAge: Int,
            @SerializedName("date")
            val mDate: String
        )
        data class Name(
            @SerializedName("first")
            val mFirst: String,
            @SerializedName("last")
            val mLast: String
        )

        data class Picture(
            @SerializedName("large")
            val mLarge: String,
            @SerializedName("thumbnail")
            val mThumbnail: String
        )
    }
}