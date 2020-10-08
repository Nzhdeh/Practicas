package com.nyeghiazaryan.eltiemporetrofit2kotlin.adaptadores

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.nyeghiazaryan.eltiemporetrofit2kotlin.R
import com.nyeghiazaryan.eltiemporetrofit2kotlin.clases.Provincia
import com.nyeghiazaryan.eltiemporetrofit2kotlin.clases.ProvinciaX
import com.nyeghiazaryan.eltiemporetrofit2kotlin.viewholders.ViewHolderProvincia
import com.nyeghiazaryan.eltiemporetrofit2kotlin.viewholders.ViewHolderTemperaturas

class AdaptadorListadoProvincias(private var contexto: Context, private var lista:List<ProvinciaX>): BaseAdapter()
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
        var holder: ViewHolderProvincia

        var nombreProvincia: TextView
        var codigoProvincia: TextView

        if(vista == null)
        {
            val layout = LayoutInflater.from(contexto)
            vista = layout.inflate(R.layout.item_listado_provincia,null)

            nombreProvincia = vista!!.findViewById(R.id.tvItemNombreProvincia)
            codigoProvincia = vista!!.findViewById(R.id.tvItemCodigoProvincia)

            holder = ViewHolderProvincia(nombreProvincia = nombreProvincia, codigoProvincia = codigoProvincia)
            vista!!.setTag(holder)
        }
        else
        {
            holder = vista.tag as ViewHolderProvincia
        }

        holder.getCodigoProvincia().setText(lista[p0].cODPROV)
        holder.getNombreProvincia().setText(lista[p0].nOMBREPROVINCIA)


        return vista!!
    }
}