package com.android.example.courseonelinkedin.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Monster(
    @Json(name = "imageFile") val imageFile: String,
    @Json(name = "monsterName") val name: String,
    @Json(name = "caption") val caption: String,
    @Json(name = "description") val description: String,
    @Json(name = "price") val price: Double,
    @Json(name = "scariness") val scariness: Int
)