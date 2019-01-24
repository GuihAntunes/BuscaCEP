package com.example.logonrmlocal.buscacep.model

import com.google.gson.annotations.SerializedName

data class Address (
    @SerializedName("cep") val zipCode: String,
    @SerializedName("logradouro") val street: String,
    @SerializedName("complemento") val street2: String,
    @SerializedName("bairro") val neighbourhood: String,
    @SerializedName("localidade") val location: String,
    @SerializedName("uf") val state: String
)