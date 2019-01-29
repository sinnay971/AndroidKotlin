package com.yannis.hebreu.beweries.data.locale

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.yannis.hebreu.beweries.data.model.Brewery


@Database(entities = [Brewery::class],version = 1,exportSchema = false)
@TypeConverters(DateConverter::class)
abstract class BreweryDatabase:RoomDatabase() {

    abstract fun breweryDAO():BreweryDAO

    companion object {
        const val DATABASE_NAME = "BreweryDatabase"
    }
}