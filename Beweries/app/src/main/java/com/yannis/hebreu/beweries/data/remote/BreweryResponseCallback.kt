package com.yannis.hebreu.beweries.data.remote

interface BreweryResponseCallback {

    fun onSuccess()

    fun onError(throwable: Throwable)
}