package com.nyeghiazaryan.eltiemporetrofit2kotlin.clases

import android.widget.TextView

class TemperaturaDTO(private var diaSemana: String, private var nombreCiudad: String, private var temperaturaMaxima: String, private var temperaturaMinima: String)
{
    fun getDiaSemana(): String
    {
        return diaSemana
    }

    fun getNombreCiudad(): String
    {
        return nombreCiudad
    }

    fun getTemperaturaMaxima(): String
    {
        return temperaturaMaxima
    }

    fun getTemperaturaMinima(): String
    {
        return temperaturaMinima
    }
}