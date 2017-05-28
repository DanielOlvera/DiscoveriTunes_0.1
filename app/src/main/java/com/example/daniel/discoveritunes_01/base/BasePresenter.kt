package com.example.daniel.discoveritunes_01.base

/**
 * Created by Daniel on 5/27/17.
 */
interface BasePresenter<V : BaseView> {
    fun addView(view: V)
    fun removeView()
}