package com.example.restapiwithretrofit

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/Offres")
    suspend fun getOffres(): Response<MutableList<offre>>
}