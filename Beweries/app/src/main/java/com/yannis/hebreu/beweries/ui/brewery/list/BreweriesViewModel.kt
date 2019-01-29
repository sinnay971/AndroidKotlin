package com.yannis.hebreu.beweries.ui.brewery.list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.yannis.hebreu.beweries.data.BreweryRepository
import com.yannis.hebreu.beweries.data.model.Brewery
import com.yannis.hebreu.beweries.data.remote.BreweryResponseCallback
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

class BreweriesViewModel(application: Application): AndroidViewModel(application), KoinComponent {

    private val breweryRepository: BreweryRepository by inject()

    var breweries: LiveData<List<Brewery>> = breweryRepository.getAll()

    fun delete(brewery: Brewery) {
        breweryRepository.delete(brewery)
    }

    fun refresh(callback: BreweryResponseCallback) {
        breweryRepository.downloadBreweries(callback)
    }
}