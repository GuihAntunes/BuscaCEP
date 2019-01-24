package com.example.logonrmlocal.buscacep.ui.search

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.logonrmlocal.buscacep.model.Address
import com.example.logonrmlocal.buscacep.repository.AddressRepository

class SearchViewModel: ViewModel() {
    val addressRepository = AddressRepository()
    val address = MutableLiveData<Address>()
    val errorMessage = MutableLiveData<String>()
    val isLoading = MutableLiveData<Boolean>()
    fun search(zipCode: String) {
        isLoading.value = true
        addressRepository.getAddress(
                zipCode,
                onComplete = {
                    isLoading.value = false
                    address.value = it
                },
                onError = {
                    isLoading.value = false
                    address.value = null
                    errorMessage.value = it?.message
                })
    }
}