package com.example.logonrmlocal.buscacep.repository

import com.example.logonrmlocal.buscacep.api.getAddressService
import com.example.logonrmlocal.buscacep.model.Address
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddressRepository {

    fun getAddress(zipCode: String,
                   onComplete:(Address?) -> Unit,
                   onError:(Throwable?) -> Unit) {
        getAddressService()
                .getAddress(zipCode)
                .enqueue(object: Callback<Address> {
                    override fun onFailure(call: Call<Address>?, t: Throwable?) {
                        onError(t)
                    }

                    override fun onResponse(call: Call<Address>?, response: Response<Address>?) {
                        if (response?.isSuccessful == true) {
                            onComplete(response?.body())
                        } else {
                            onError(Throwable("Não foi possível buscar o CEP!"))
                        }
                    }

                })
    }
}