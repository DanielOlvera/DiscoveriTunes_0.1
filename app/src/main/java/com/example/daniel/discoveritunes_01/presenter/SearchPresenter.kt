package com.example.daniel.discoveritunes_01.presenter

import android.content.Context
import com.example.daniel.discoveritunes_01.model.Result
import com.example.daniel.discoveritunes_01.model.api.ApiClient
import com.example.daniel.discoveritunes_01.model.api.ApiInterface
import com.example.daniel.discoveritunes_01.view.search.SearchListContract
import java.util.ArrayList

/**
 * Created by Daniel on 5/27/17.
 */

class SearchPresenter : SearchListContract.Presenter{

    var view : SearchListContract.View ?= null
    private val items = ArrayList<Result>()

    override fun addView(view: SearchListContract.View) {
        this.view = view
    }

    override fun removeView() {
        this.view = null
    }

    override fun getVideoList() {
        val videosObservable =
    }

    override fun searchList(searchString: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showDialog(context: Context) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}