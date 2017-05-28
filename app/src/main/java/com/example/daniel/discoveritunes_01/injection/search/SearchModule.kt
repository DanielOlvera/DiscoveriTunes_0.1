package com.example.daniel.discoveritunes_01.injection.search

import com.example.daniel.discoveritunes_01.presenter.SearchPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Daniel on 5/27/17.
 */

@Module
class SearchModule {

    @Provides
    @Singleton
    fun searchPresenterProvider(): SearchPresenter {
        return SearchPresenter()
    }
}