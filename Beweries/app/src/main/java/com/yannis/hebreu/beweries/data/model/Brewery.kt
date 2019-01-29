package com.yannis.hebreu.beweries.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "brewery")
data class Brewery(
    @PrimaryKey
    override var id: Int = 0,

    var name:String = "Sans nom",

    @ColumnInfo(name = "brewery_type")
    var breweryType: String  = "sans type",


    var street: String  = "sans street",

    var city: String  = "sans city",

    var state: String  = "sans state",

    @ColumnInfo(name = "postal_code")
    var postalCode: String  = "sans postal code",

    var country: String  = "sans country",

    var longitude: String  = "sans longitude",

    var latitude: String  = "sans latitude",

    var phone: String  = "sans phone",

    @ColumnInfo(name = "website_url")
    var websiteUrl: String  = "sans website url",

    @ColumnInfo(name = "updated_at")
    var updatedAt: Date  = Date()

): BaseObject {
}