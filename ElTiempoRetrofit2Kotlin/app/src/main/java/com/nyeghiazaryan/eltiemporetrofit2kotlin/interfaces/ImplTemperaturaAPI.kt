package com.nyeghiazaryan.eltiemporetrofit2kotlin.interfaces

import com.nyeghiazaryan.eltiemporetrofit2kotlin.clases.Municipio
import com.nyeghiazaryan.eltiemporetrofit2kotlin.clases.Provincia
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ImplTemperaturaAPI
{
    @GET("provincias")
    fun getProvincias(): Call<Provincia>

    @GET("provincias/{CODPROV}")
    fun getProvincias(@Path("CODPROV") CODPROV:String): Call<Provincia>

    @GET("municipios")
    fun getMunicipios(): Call<Municipio>
}