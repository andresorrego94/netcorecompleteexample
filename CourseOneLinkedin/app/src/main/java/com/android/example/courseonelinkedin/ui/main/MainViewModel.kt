package com.android.example.courseonelinkedin.ui.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.android.example.courseonelinkedin.LOG_TAG
import com.android.example.courseonelinkedin.data.Monster
import com.android.example.courseonelinkedin.utils.FileHelper
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types


class MainViewModel(app: Application) : AndroidViewModel(app) {
    // TODO: Implement the ViewModel
    private val listType = Types.newParameterizedType(
        List::class.java, Monster::class.java
    )
    //al iniciar
    init {
        //GET FILE FROM RESOURCES
        //val text = FileHelper.getTextFromResources(app, R.raw.monster_data)

        //GET FILE FROM ASSETS
        val text = FileHelper.getTextFromAssets(app, "monster_data.json")
        parseText(text)
        //var a = text
    }

    fun parseText(text: String) {
        val moshi = Moshi.Builder().build()

        val adapter = moshi.adapter<List<Monster>>(listType)

        val monsterData = adapter.fromJson(text)

        for (monster in monsterData ?: emptyList()) {
            Log.i(LOG_TAG,
                "${monster.name} (\$${monster.price})")
        }
    }

}