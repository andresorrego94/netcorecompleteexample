package com.android.example.courseonelinkedin.data

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import androidx.annotation.WorkerThread
import androidx.lifecycle.MutableLiveData
import com.android.example.courseonelinkedin.LOG_TAG
import com.android.example.courseonelinkedin.R
import com.android.example.courseonelinkedin.WEB_SERVICE_URL
import com.android.example.courseonelinkedin.utils.FileHelper
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MonsterRepository(val app: Application) {
    val monsterData = MutableLiveData<List<Monster>>()

    private val listType = Types.newParameterizedType(
        List::class.java, Monster::class.java
    )

    init {
        //getMonsterData(app)
        refreshData()
    }

    @WorkerThread
    suspend fun callWebService(){
        if (networkAvailable()){
            val retrofit = Retrofit.Builder()
                .baseUrl(WEB_SERVICE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
            val service = retrofit.create(MonsterService::class.java)
            val serviceData = service.getMonsterData().body() ?: emptyList()
            monsterData.postValue(serviceData)
        }
    }

    fun getMonsterData(context: Context){
        //FROM RESOURCES
        //val text = FileHelper.getTextFromResources(context, R.raw.monster_data)
        //FROM ASSETS
        //GET FILE FROM ASSETS
        val text = FileHelper.getTextFromAssets(context, "monster_data.json")

        val moshi = Moshi.Builder().build()
        val adapter = moshi.adapter<List<Monster>>(listType)
        val data = adapter.fromJson(text)

        monsterData.value = data ?: emptyList()
    }

    private fun networkAvailable(): Boolean {
        val connectivityManager = app.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo?.isConnectedOrConnecting ?: false;
    }

    fun refreshData() {
        CoroutineScope(Dispatchers.IO).launch {
            callWebService()
        }
    }


}