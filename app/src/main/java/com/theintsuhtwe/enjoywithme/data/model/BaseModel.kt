package com.theintsuhtwe.enjoywithme.data.model



import android.content.Context
import com.theintsuhtwe.enjoywithme.network.response.MoviesApi
import com.theintsuhtwe.enjoywithme.persistence.db.MoviesDB
import com.theintsuhtwe.enjoywithme.utils.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

abstract class BaseModel {

    protected var mMoviesApi: MoviesApi

    protected lateinit var mTheDB: MoviesDB
    init {
        val mOkHttpClient = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(mOkHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        mMoviesApi = retrofit.create(MoviesApi::class.java)



    }

    fun initDatabase(context: Context) {
        mTheDB = MoviesDB.getDBInstance(context)
    }
}