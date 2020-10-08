package com.nyeghiazaryan.eltiemporetrofit2kotlin.fragments

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.location.*
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.nyeghiazaryan.eltiemporetrofit2kotlin.R
import com.nyeghiazaryan.eltiemporetrofit2kotlin.adaptadores.AdaptadorListadoProvincias
import com.nyeghiazaryan.eltiemporetrofit2kotlin.clases.Municipio
import com.nyeghiazaryan.eltiemporetrofit2kotlin.clases.MunicipioItem
import com.nyeghiazaryan.eltiemporetrofit2kotlin.clases.Provincia
import com.nyeghiazaryan.eltiemporetrofit2kotlin.clases.ProvinciaX
import com.nyeghiazaryan.eltiemporetrofit2kotlin.interfaces.ImplTemperaturaAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LatitudLongitudFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LatitudLongitudFragment : Fragment()
{
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var locationManager: LocationManager
    private var hasGps = false
    private var hasNetwork = false
    private var locationGps: Location? = null

    private lateinit var retrofit: Retrofit
    private lateinit var implTemperaturaAPI: ImplTemperaturaAPI

    private lateinit var temperaturaMaxima: TextView
    private lateinit var temperaturaMinima: TextView
    private lateinit var tvCiudad: TextView
    private lateinit var lvListadoTemperaturas: ListView
    private lateinit var geocoder: Geocoder

    private lateinit var listadoMunicipios: Municipio
    private lateinit var listadoProvincias: List<ProvinciaX>

    lateinit var adapter : AdaptadorListadoProvincias


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        var view = inflater.inflate(R.layout.fragment_latitud_longitud, container, false)

        temperaturaMaxima = view.findViewById(R.id.tvMaxTemp)
        temperaturaMinima = view.findViewById(R.id.tvMinTemp)
        tvCiudad = view.findViewById(R.id.tvCiudad)
        lvListadoTemperaturas = view.findViewById(R.id.lvListadoTemperaturas)

        getLocation()

//        obtenerListadoProvincias()
        obtenerListadoMunicipios()
//
//        if (listadoMunicipios!= null)
//        {
//            obtenerListadoTemperaturas()
//        }


        return view
    }

//    private fun obtenerListadoTemperaturas()
//    {
//        retrofit = Retrofit.Builder()
//            .baseUrl("https://www.el-tiempo.net/api/json/v2/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//
//        val service = retrofit.create<ImplTemperaturaAPI>(ImplTemperaturaAPI::class.java)
//
//        service.getProvincias(obtenerCodigoProvinciaPorPorMunicipio()).enqueue(object : Callback<Provincia>
//        {
//            override fun onResponse(call: Call<Provincia>, response: Response<Provincia>)
//            {
//                if (response.isSuccessful)
//                {
//                    val temperaturas = response.body()
//                }
//            }
//
//            override fun onFailure(call: Call<Provincia>, t: Throwable)
//            {
//                Toast.makeText(requireContext(), "error", Toast.LENGTH_LONG).show()
//            }
//
//        })
//    }

//    private fun obtenerCodigoProvinciaPorPorMunicipio(): String
//    {
//        var idProvincia = "0"
//
//        for (item in listadoMunicipios)
//        {
//            if(item.nOMBRE.equals(tvCiudad.text.toString(), true))
//            {
//                idProvincia = item.cODPROV
//            }
//        }
//
//        return idProvincia
//    }

//    private fun obtenerListadoProvincias()
//    {
//        retrofit = Retrofit.Builder()
//            .baseUrl("https://www.el-tiempo.net/api/json/v2/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//
//        val service = retrofit.create(ImplTemperaturaAPI::class.java)
//
//        service.getProvincias().enqueue(object : Callback<Provincia>
//        {
//            override fun onResponse(call: Call<Provincia>, response: Response<Provincia>)
//            {
//                if (response.isSuccessful)
//                {
//                    val provincias = response.body()
//
////                    if (provincias != null) {
////                        listadoProvincias = provincias.provincias
////
////                        adapter = AdaptadorListadoProvincias(requireContext(), listadoProvincias)
////                        lvListadoProvincias.setAdapter(adapter)
////                    }
//                }
//            }
//
//            override fun onFailure(call: Call<Provincia>, t: Throwable)
//            {
//                Toast.makeText(requireContext(), "error", Toast.LENGTH_LONG).show()
//            }
//        })
//    }

    private fun obtenerListadoMunicipios()
    {
        retrofit = Retrofit.Builder()
            .baseUrl("https://www.el-tiempo.net/api/json/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(ImplTemperaturaAPI::class.java)

        service.getMunicipios().enqueue(object : Callback<Municipio>
        {
            override fun onResponse(call: Call<Municipio>, response: Response<Municipio>)
            {
                if (response.isSuccessful)
                {
                    listadoMunicipios = response.body()!!
                }
                else
                {
                    Toast.makeText(requireContext(), "response error", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<Municipio>, t: Throwable) {
                Toast.makeText(requireContext(), "Error", Toast.LENGTH_LONG).show()
            }
        })
    }


    private fun getLocation()
    {
        locationManager = context?.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        hasGps = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
        hasNetwork = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
        if (hasNetwork) {

            if (hasGps) {
                //Log.d("CodeAndroidLocation", "hasGps")
                if (ActivityCompat.checkSelfPermission(
                        requireContext(),
                        Manifest.permission.ACCESS_FINE_LOCATION
                    ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                        requireContext(),
                        Manifest.permission.ACCESS_COARSE_LOCATION
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    ActivityCompat.requestPermissions(
                        requireActivity(),
                        arrayOf(
                            Manifest.permission.ACCESS_COARSE_LOCATION,
                            Manifest.permission.ACCESS_FINE_LOCATION
                        ), 1010
                    )
                }
                locationManager.requestLocationUpdates(
                    LocationManager.NETWORK_PROVIDER,
                    1000,
                    1F,
                    object : LocationListener {
                        override fun onLocationChanged(location: Location)
                        {
                            if (location != null) {
                                locationGps = location

                                var lat = locationGps!!.latitude
                                var lon = locationGps!!.longitude

                                geocoder = Geocoder(
                                    (context as Activity).baseContext,
                                    Locale.getDefault()
                                )


                                var addresses: List<Address> = geocoder.getFromLocation(
                                    lat,
                                    lon,
                                    1
                                )

//                                Toast.makeText(
//                                    requireContext(),
//                                    "tamaño: " + addresses.size.toString(),
//                                    Toast.LENGTH_LONG
//                                ).show()

                                if (addresses.size > 0) {
                                    var direccion: String = addresses.get(0).getAddressLine(0)
                                    val city: String = addresses.get(0).getLocality()
                                    //val country: String = addresses.get(0).getCountryName()

                                    tvCiudad.setText(city)
                                } else {
                                    Toast.makeText(
                                        requireContext(),
                                        "No hay conexión",
                                        Toast.LENGTH_LONG
                                    ).show()
                                }
                            }
                        }
                    })

//                val localGpsLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
//                if (localGpsLocation != null)
//                    locationGps = localGpsLocation
            }
            else{
                Toast.makeText(requireContext(), "Enciende la ubicación", Toast.LENGTH_LONG)
            }
        }else{
            Toast.makeText(requireContext(), "No hay conexión a internet", Toast.LENGTH_LONG)
        }
    }


    companion object
    {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LatitudLongitudFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LatitudLongitudFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}




