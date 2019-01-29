package com.yannis.hebreu.beweries.data.remote

import com.google.gson.annotations.SerializedName

data class BreweryResponse(
                          @SerializedName("id")
                          var id: Int = 0,
                          @SerializedName("name")
                          var name:String,

                          @SerializedName("brewery_type")
                          var breweryType: String,

                          @SerializedName("street")
                          var street: String,

                          @SerializedName("city")
                          var city: String,
                          @SerializedName("state")
                          var state: String,

                          @SerializedName("postal_code")
                          var postalCode: String,

                          @SerializedName("country")
                          var country: String ,

                          @SerializedName("longitude")
                          var longitude: String,

                          @SerializedName("latitude")
                          var latitude: String,

                          @SerializedName("phone")
                          var phone: String,

                          @SerializedName("website_url")
                          var websiteUrl: String,

                          @SerializedName("updated_at" )
                          var updatedAt: String) {
}