package com.nyeghiazaryan.eltiemporetrofit2kotlin.clases

import com.google.gson.annotations.SerializedName

data class Provincia(
    @SerializedName("breadcrumb")
    val breadcrumb: List<Breadcrumb>,
    @SerializedName("keywords")
    val keywords: String,
    @SerializedName("metadescripcion")
    val metadescripcion: String,
    @SerializedName("provincias")
    val provincias: List<ProvinciaX>,
    @SerializedName("title")
    val title: String
)
{

}
data class ProvinciaX(
    @SerializedName("CAPITAL_PROVINCIA")
    val cAPITALPROVINCIA: String,
    @SerializedName("CODAUTON")
    val cODAUTON: String,
    @SerializedName("CODPROV")
    val cODPROV: String,
    @SerializedName("COMUNIDAD_CIUDAD_AUTONOMA")
    val cOMUNIDADCIUDADAUTONOMA: String,
    @SerializedName("NOMBRE_PROVINCIA")
    val nOMBREPROVINCIA: String
)
{
    @JvmName("getNOMBREPROVINCIA1")
    fun getNOMBREPROVINCIA(): String
    {
        return nOMBREPROVINCIA
    }

    @JvmName("getCODPROV1")
    fun getCODPROV(): String
    {
        return cODPROV
    }
}