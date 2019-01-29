package com.yannis.hebreu.beweries.ui

import com.yannis.hebreu.beweries.ui.brewery.detail.DetailBreweryViewModel
import com.yannis.hebreu.beweries.ui.brewery.list.BreweriesViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val viewModule = module {

    viewModel { BreweriesViewModel(androidApplication()) }

    viewModel { DetailBreweryViewModel(androidApplication()) }
}