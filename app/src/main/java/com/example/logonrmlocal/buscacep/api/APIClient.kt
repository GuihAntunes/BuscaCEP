package com.example.logonrmlocal.buscacep.api

import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIClient<T> {
    fun getClient(c: Class<T>): T {
        val okHttp = OkHttpClient.Builder()
                .addNetworkInterceptor(StethoInterceptor())
                .build()

        val retrofit = Retrofit.Builder()
                .baseUrl("https://viacep.com.br/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttp)
                .build()

        return retrofit.create(c)
    }
}

fun getAddressService(): AddressService {
    return APIClient<AddressService>().getClient(AddressService::class.java)
}