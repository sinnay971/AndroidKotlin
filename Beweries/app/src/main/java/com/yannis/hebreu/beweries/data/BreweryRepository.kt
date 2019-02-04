package com.yannis.hebreu.beweries.data

import android.util.Log
import androidx.lifecycle.LiveData
import com.yannis.hebreu.beweries.data.locale.BreweryDAO
import com.yannis.hebreu.beweries.data.model.Brewery
import com.yannis.hebreu.beweries.data.remote.BreweryResponse
import com.yannis.hebreu.beweries.data.remote.BreweryResponseCallback
import com.yannis.hebreu.beweries.data.remote.BreweryService
import com.yannis.hebreu.beweries.extension.toDate
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.doAsync
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject
import java.util.*

class BreweryRepository: KoinComponent {

    private val breweryDAO:BreweryDAO by inject()

    private val service = BreweryService.create()

    //region locale

    fun insertAll(breweries: List<Brewery>) = doAsync {
        breweryDAO.insertAll(breweries)
        Log.d("breweryRepository","inserting breweries: $breweries")
    }

    fun delete(brewery: Brewery) = doAsync { breweryDAO.delete(brewery) }

    fun getById(id: Int): LiveData<Brewery> = breweryDAO.getBeweryById(id)

    fun getAll(): LiveData<List<Brewery>> = breweryDAO.getAllBeweries()

    //endregion

    //region remote

    fun downloadBreweries(callback: BreweryResponseCallback) {
        service.getBeweries()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onNext = { breweriesListResponse -> insertAll(breweriesListResponse.map { breweryResponse -> breweriesResponseToBrewery(breweryResponse) }) },
                onComplete = { callback.onSuccess() },
                onError = { callback.onError(it) }
            )
    }


    private fun breweriesResponseToBrewery(breweryResponse: BreweryResponse): Brewery =
        Brewery(
            id = breweryResponse.id,
            name = breweryResponse.name,
            breweryType = breweryResponse.breweryType,
            street = breweryResponse.street,
            city = breweryResponse.city,
            country = breweryResponse.country,
            state = breweryResponse.state,
            postalCode = breweryResponse.postalCode,
            longitude = breweryResponse.longitude,
            latitude = breweryResponse.latitude,
            phone = breweryResponse.phone,
            websiteUrl = breweryResponse.websiteUrl,
            updatedAt = breweryResponse.updatedAt.toDate("yyyy-MM-dd") ?: Date()
        )

    //endregion
}