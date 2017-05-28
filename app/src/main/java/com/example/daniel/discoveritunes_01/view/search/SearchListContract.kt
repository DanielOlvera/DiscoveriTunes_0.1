package com.example.daniel.discoveritunes_01.view.search

import android.content.Context
import com.example.daniel.discoveritunes_01.base.BasePresenter
import com.example.daniel.discoveritunes_01.base.BaseView
import com.example.daniel.discoveritunes_01.model.Result

/**
 * Created by Daniel on 5/27/17.
 */
interface SearchListContract {

    interface View : BaseView {

        fun updateList(items: List<Result>)
        fun updateSearchResults(items: List<Result>)

    }

    interface Presenter : BasePresenter<View> {

        fun getVideoList()
        fun searchList(term: String, entity : String)
        fun showSpinner(context: Context)

    }
}