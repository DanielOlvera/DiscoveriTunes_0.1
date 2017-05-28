package com.example.daniel.discoveritunes_01.model.api

import com.example.daniel.discoveritunes_01.model.ITunesResult
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

/**
 * Created by Daniel on 5/27/17.
 */
/*
    This class provides the observable method for the parameters
    to fulfill the endpoint and retrieve the data
 */

interface ApiInterface {

    @GET("search")
    fun getSearch(
            @Query("term") term: String,
            @Query("entity") entityITns: String
    ): Observable<ITunesResult>

}