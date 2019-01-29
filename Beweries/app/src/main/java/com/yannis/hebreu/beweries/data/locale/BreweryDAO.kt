package com.yannis.hebreu.beweries.data.locale

import androidx.lifecycle.LiveData
import androidx.room.*
import com.yannis.hebreu.beweries.data.model.Brewery

@Dao
interface BreweryDAO {

    @Query("SELECT * FROM brewery WHERE id = :id")
    fun getBeweryById(id:Int) : LiveData<Brewery>

    @Query("SELECT * FROM brewery WHERE name = :name")
    fun getBeweryBy(name:String) : LiveData<Brewery>

    @Query("SELECT * FROM brewery WHERE brewery_type = :type")
    fun getBeweriesType(type:String) : LiveData<List<Brewery>>

    @Query("SELECT * FROM brewery")
    fun getAllBeweries() :  LiveData<List<Brewery>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(brewery: Brewery)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list: List<Brewery>)

    @Delete
    fun delete(brewery:Brewery)
}