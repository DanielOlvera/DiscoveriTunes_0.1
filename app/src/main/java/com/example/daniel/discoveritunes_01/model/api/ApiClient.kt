package com.example.daniel.discoveritunes_01.model.api

import com.example.daniel.discoveritunes_01.BuildConfig
import com.example.daniel.discoveritunes_01.model.ITunesResult
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import rx.Observable

/**
 * Created by Daniel on 5/27/17.
 */
/*
    This is the singleton class to instantiate retrofit
 */
class ApiClient {

    private val BASE_URL = BuildConfig.BASE_URL;
    private var retrofit: Retrofit? = null

    fun getClient(): Retrofit? {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
        }
        return retrofit
    }
}

//This is the expected URL to be generated:
// https://itunes.apple.com/search?term=jack+johnson&entity=musicVideo