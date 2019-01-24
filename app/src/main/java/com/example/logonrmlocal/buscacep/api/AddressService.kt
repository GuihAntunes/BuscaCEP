package com.example.logonrmlocal.buscacep.api

import com.example.logonrmlocal.buscacep.model.Address
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface AddressService {
    @GET("ws/{zipCode}/json/")
    fun getAddress(@Path("zipCode") zipCode: String): Call<Address>
}