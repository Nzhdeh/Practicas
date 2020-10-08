package com.nyeghiazaryan.eltiemporetrofit2kotlin.viewholders

import android.widget.TextView

class ViewHolderProvincia(private var nombreProvincia: TextView, private var codigoProvincia: TextView)
{
    fun getNombreProvincia(): TextView
    {
        return nombreProvincia
    }

    fun getCodigoProvincia(): TextView
    {
        return codigoProvincia
    }
}