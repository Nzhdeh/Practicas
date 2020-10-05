package com.nyeghiazaryan.eltiemporetrofit2kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import com.nyeghiazaryan.eltiemporetrofit2kotlin.fragments.LatitudLongitudFragment

class MainActivity : AppCompatActivity()
{
    private lateinit var contenedor: ViewGroup

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        contenedor = findViewById(R.id.flContenedor)

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        val fragment = LatitudLongitudFragment()
        fragmentTransaction.add(R.id.flContenedor, fragment)
        fragmentTransaction.commit()
    }
}