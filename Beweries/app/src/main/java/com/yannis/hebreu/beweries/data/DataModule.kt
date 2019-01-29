package com.yannis.hebreu.beweries.data

import androidx.room.Room
import com.yannis.hebreu.beweries.data.locale.BreweryDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.module


val dataModule = module {

    single { Room.databaseBuilder(androidApplication(), BreweryDatabase::class.java, BreweryDatabase.DATABASE_NAME).build() }

    single { get<BreweryDatabase>().breweryDAO() }

    single { BreweryRepository() }

}