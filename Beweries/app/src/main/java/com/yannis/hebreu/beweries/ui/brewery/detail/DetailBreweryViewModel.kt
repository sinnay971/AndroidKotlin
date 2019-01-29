package com.yannis.hebreu.beweries.ui.brewery.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.yannis.hebreu.beweries.data.BreweryRepository
import com.yannis.hebreu.beweries.data.model.Brewery
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

class DetailBreweryViewModel (application: Application): AndroidViewModel(application), KoinComponent {

    private val breweryRepository: BreweryRepository by inject()

    var breweryId: MutableLiveData<Int> = MutableLiveData()

    var brewery: LiveData<Brewery> = Transformations.switchMap(breweryId) { id -> breweryRepository.getById(id) }
}