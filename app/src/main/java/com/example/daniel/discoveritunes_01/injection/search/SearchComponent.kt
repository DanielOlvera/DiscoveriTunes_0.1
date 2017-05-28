package com.example.daniel.discoveritunes_01.injection.search

import com.example.daniel.discoveritunes_01.view.search.SearchActivity
import dagger.Component

/**
 * Created by Daniel on 5/27/17.
 */

@Component(modules = arrayOf(SearchModule::class))
interface SearchComponent {
    fun inject(searchActivity: SearchActivity)
}