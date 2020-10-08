package com.nyeghiazaryan.eltiemporetrofit2kotlin.viewholders

import android.widget.TextView

class ViewHolderTemperaturas(private var diaSemana: TextView, private var nombreCiudad: TextView, private var temperaturaMaxima: TextView, private var temperaturaMinima: TextView)
{
    fun getDiaSemana(): TextView
    {
        return diaSemana
    }

    fun getNombreCiudad(): TextView
    {
        return nombreCiudad
    }

    fun getTemperaturaMaxima(): TextView
    {
        return temperaturaMaxima
    }

    fun getTemperaturaMinima(): TextView
    {
        return temperaturaMinima
    }
}