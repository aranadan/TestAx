package com.touchcard.testax.data.models


import com.google.gson.annotations.SerializedName


data class ApiResponse(
    @SerializedName("info")
    val mInfo: Info,
    @SerializedName("results")
    val mResults: List<Result>
) {
    data class Info(
        @SerializedName("page")
        val mPage: Int,
        @SerializedName("results")
        val mResults: Int,
        @SerializedName("seed")
        val mSeed: String,
        @SerializedName("version")
        val mVersion: String
    )

    data class Result(
        @SerializedName("cell")
        val mCell: String,
        @SerializedName("dob")
        val mDob: Dob,
        @SerializedName("email")
        val mEmail: String,
        @SerializedName("gender")
        val mGender: String,
        @SerializedName("id")
        val mId: Id,
        @SerializedName("location")
        val mLocation: Location,
        @SerializedName("login")
        val mLogin: Login,
        @SerializedName("name")
        val mName: Name,
        @SerializedName("nat")
        val mNat: String,
        @SerializedName("phone")
        val mPhone: String,
        @SerializedName("picture")
        val mPicture: Picture,
        @SerializedName("registered")
        val mRegistered: Registered
    ) {
        data class Dob(
            @SerializedName("age")
            val mAge: Int,
            @SerializedName("date")
            val mDate: String
        )

        data class Id(
            @SerializedName("name")
            val mName: String,
            @SerializedName("value")
            val mValue: String
        )

        data class Location(
            @SerializedName("city")
            val mCity: String,
            @SerializedName("coordinates")
            val mCoordinates: Coordinates,
            @SerializedName("country")
            val mCountry: String,
            @SerializedName("state")
            val mState: String,
            @SerializedName("street")
            val mStreet: Street,
            @SerializedName("timezone")
            val mTimezone: Timezone
        ) {
            data class Coordinates(
                @SerializedName("latitude")
                val mLatitude: String,
                @SerializedName("longitude")
                val mLongitude: String
            )

            data class Street(
                @SerializedName("name")
                val mName: String,
                @SerializedName("number")
                val mNumber: Int
            )

            data class Timezone(
                @SerializedName("description")
                val mDescription: String,
                @SerializedName("offset")
                val mOffset: String
            )
        }

        data class Login(
            @SerializedName("md5")
            val mMd5: String,
            @SerializedName("password")
            val mPassword: String,
            @SerializedName("salt")
            val mSalt: String,
            @SerializedName("sha1")
            val mSha1: String,
            @SerializedName("sha256")
            val mSha256: String,
            @SerializedName("username")
            val mUsername: String,
            @SerializedName("uuid")
            val mUuid: String
        )

        data class Name(
            @SerializedName("first")
            val mFirst: String,
            @SerializedName("last")
            val mLast: String,
            @SerializedName("title")
            val mTitle: String
        )

        data class Picture(
            @SerializedName("large")
            val mLarge: String,
            @SerializedName("medium")
            val mMedium: String,
            @SerializedName("thumbnail")
            val mThumbnail: String
        )

        data class Registered(
            @SerializedName("age")
            val mAge: Int,
            @SerializedName("date")
            val mDate: String
        )
    }
}