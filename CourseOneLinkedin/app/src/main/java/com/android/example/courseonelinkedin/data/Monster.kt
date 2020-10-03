package com.android.example.courseonelinkedin.data

import com.android.example.courseonelinkedin.IMAGE_BASE_URL
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
) {
    //val imageUrl get() = "$IMAGE_BASE_URL/$imageFile.webp"
    val imageUrl get() = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/132.png"
    val thumbnailUrl get() = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/132.png"
}