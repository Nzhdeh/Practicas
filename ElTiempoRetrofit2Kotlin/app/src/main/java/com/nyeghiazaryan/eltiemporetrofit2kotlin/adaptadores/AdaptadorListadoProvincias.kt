package com.nyeghiazaryan.eltiemporetrofit2kotlin.adaptadores

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.nyeghiazaryan.eltiemporetrofit2kotlin.R
import com.nyeghiazaryan.eltiemporetrofit2kotlin.clases.Ciudade
import com.nyeghiazaryan.eltiemporetrofit2kotlin.clases.Provincia
import com.nyeghiazaryan.eltiemporetrofit2kotlin.clases.ProvinciaX
import com.nyeghiazaryan.eltiemporetrofit2kotlin.clases.Temperaturas
import com.nyeghiazaryan.eltiemporetrofit2kotlin.viewholders.ViewHolderProvincia
import com.nyeghiazaryan.eltiemporetrofit2kotlin.viewholders.ViewHolderTemperaturas

class AdaptadorListadoProvincias(private var contexto: Context, private var lista: List<Ciudade>): BaseAdapter()
{
    override fun getCount(): Int
    {
        return lista.count()
    }

    override fun getItem(p0: Int): Any
    {
        return lista.get(p0)
    }

    override fun getItemId(p0: Int): Long
    {
        return 0
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View
    {
        var vista = p1
        var holder: ViewHolderTemperaturas

        var diaSemana: TextView
        var nombreCiudad: TextView
        var temperaturaMaxima: TextView
        var temperaturaMinima: TextView

        var dia = "Miercoles"

        if(vista == null)
        {
            val layout = LayoutInflater.from(contexto)
            vista = layout.inflate(R.layout.item_listado_provincia,null)

            //diaSemana = vista!!.findViewById(R.id.tvItemDiaSemana)
            nombreCiudad = vista!!.findViewById(R.id.tvItemCiudad)
            temperaturaMaxima = vista!!.findViewById(R.id.tvItemTempMax)
            temperaturaMinima = vista!!.findViewById(R.id.tvItemTempMin)

            holder = ViewHolderTemperaturas(nombreCiudad = nombreCiudad, temperaturaMaxima = temperaturaMaxima, temperaturaMinima = temperaturaMinima)
            vista!!.setTag(holder)
        }
        else
        {
            holder = vista.tag as ViewHolderTemperaturas
        }

        //holder.getDiaSemana().setText(dia)
        holder.getNombreCiudad().setText(lista[p0].name)
        holder.getTemperaturaMaxima().setText(lista[p0].temperatures.max)
        holder.getTemperaturaMinima().setText(lista[p0].temperatures.min)


        return vista!!
    }
}