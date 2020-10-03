package com.android.example.courseonelinkedin.ui.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.android.example.courseonelinkedin.LOG_TAG
import com.android.example.courseonelinkedin.data.Monster
import com.android.example.courseonelinkedin.data.MonsterRepository
import com.android.example.courseonelinkedin.utils.FileHelper
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types


class MainViewModel(app: Application) : AndroidViewModel(app) {
    private val monsterRepository = MonsterRepository(app)
    val monsterData = monsterRepository.monsterData

    fun refreshData() {
        monsterRepository.refreshData()
    }

}