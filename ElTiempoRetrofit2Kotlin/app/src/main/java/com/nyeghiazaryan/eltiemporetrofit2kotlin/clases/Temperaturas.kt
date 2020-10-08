package com.nyeghiazaryan.eltiemporetrofit2kotlin.clases

import com.google.gson.annotations.SerializedName

data class Temperaturas(
    @SerializedName("breadcrumb")
    val breadcrumb: List<Breadcrumb>,
    @SerializedName("ciudades")
    val ciudades: List<Ciudade>,
    @SerializedName("comautonoma")
    val comautonoma: Comautonoma,
    @SerializedName("keywords")
    val keywords: String,
    @SerializedName("metadescripcion")
    val metadescripcion: String,
    @SerializedName("provincia")
    val provincia: Provincia,
    @SerializedName("title")
    val title: String,
    @SerializedName("today")
    val today: Today,
    @SerializedName("tomorrow")
    val tomorrow: Tomorrow
)


data class Ciudade(
    @SerializedName("id")
    val id: String,
    @SerializedName("idProvince")
    val idProvince: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("nameProvince")
    val nameProvince: String,
    @SerializedName("stateSky")
    val stateSky: StateSky,
    @SerializedName("temperatures")
    val temperatures: Temperatures
)


data class Comautonoma(
    @SerializedName("CODAUTON")
    val cODAUTON: String,
    @SerializedName("CODCOMUN")
    val cODCOMUN: String,
    @SerializedName("ID")
    val iD: String,
    @SerializedName("NOMBRE")
    val nOMBRE: String
)


data class Today(
    @SerializedName("p")
    val p: String
)

data class Tomorrow(
    @SerializedName("p")
    val p: String
)

data class StateSky(
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: String
)

data class Temperatures(
    @SerializedName("max")
    val max: String,
    @SerializedName("min")
    val min: String
)