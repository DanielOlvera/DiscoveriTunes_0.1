package com.example.daniel.discoveritunes_01.presenter

import android.content.Context
import android.util.Log
import com.example.daniel.discoveritunes_01.model.Result
import com.example.daniel.discoveritunes_01.model.api.ApiInterface
import com.example.daniel.discoveritunes_01.view.search.SearchListContract
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import java.util.*

/**
 * Created by Daniel on 5/27/17.
 */

class SearchPresenter : SearchListContract.Presenter{

    var view : SearchListContract.View ?= null
    private val results = ArrayList<Result>()

    override fun addView(view: SearchListContract.View) {
        this.view = view
    }

    override fun removeView() {
        this.view = null
    }

    override fun getVideoList() {
        val apiService = ApiInterface.create();
        apiService.getSearch("jack+johnson", "") //TODO: Set default values
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe ({
                    result ->
                    Log.d("Result", "There are ${result.results.size} tracks in iTunes")
                }, { error ->
                    error.printStackTrace()
                })
    }

    override fun searchList(term: String, entity : String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showSpinner(context: Context) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}