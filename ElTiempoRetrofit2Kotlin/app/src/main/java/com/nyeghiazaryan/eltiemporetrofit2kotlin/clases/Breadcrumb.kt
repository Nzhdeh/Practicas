package com.nyeghiazaryan.eltiemporetrofit2kotlin.clases

import com.google.gson.annotations.SerializedName

data class Breadcrumb(
    @SerializedName("name")
    val name: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: Any
)
