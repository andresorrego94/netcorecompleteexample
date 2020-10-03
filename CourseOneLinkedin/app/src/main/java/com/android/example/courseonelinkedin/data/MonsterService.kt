package com.android.example.courseonelinkedin.data

import retrofit2.Response
import retrofit2.http.GET

interface MonsterService {
    @GET("/monsters.json")
    suspend fun getMonsterData(): Response<List<Monster>>
}