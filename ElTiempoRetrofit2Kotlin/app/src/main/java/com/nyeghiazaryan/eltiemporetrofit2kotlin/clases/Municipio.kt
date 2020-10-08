package com.nyeghiazaryan.eltiemporetrofit2kotlin.clases

import com.google.gson.annotations.SerializedName

class Municipio : ArrayList<MunicipioItem>()
{

}


data class MunicipioItem(
    @SerializedName("ALTITUD")
    val aLTITUD: Double,
    @SerializedName("COD_GEO")
    val cODGEO: String,
    @SerializedName("CODIGOINE")
    val cODIGOINE: String,
    @SerializedName("CODIGOINE_CAPITAL")
    val cODIGOINECAPITAL: String,
    @SerializedName("CODPROV")
    val cODPROV: String,
    @SerializedName("DISCREPANTE_INE")
    val dISCREPANTEINE: Int,
    @SerializedName("HOJA_MTN25")
    val hOJAMTN25: String,
    @SerializedName("ID_REL")
    val iDREL: String,
    @SerializedName("LATITUD_ETRS89_REGCAN95")
    val lATITUDETRS89REGCAN95: Double,
    @SerializedName("LONGITUD_ETRS89_REGCAN95")
    val lONGITUDETRS89REGCAN95: Double,
    @SerializedName("NOMBRE")
    val nOMBRE: String,
    @SerializedName("NOMBRE_CAPITAL")
    val nOMBRECAPITAL: String,
    @SerializedName("NOMBRE_PROVINCIA")
    val nOMBREPROVINCIA: String,
    @SerializedName("ORIGEN_ALTITUD")
    val oRIGENALTITUD: String,
    @SerializedName("ORIGEN_COORD")
    val oRIGENCOORD: String,
    @SerializedName("PERIMETRO")
    val pERIMETRO: Int,
    @SerializedName("POBLACION_CAPITAL")
    val pOBLACIONCAPITAL: String,
    @SerializedName("POBLACION_MUNI")
    val pOBLACIONMUNI: Int,
    @SerializedName("SUPERFICIE")
    val sUPERFICIE: Double
)