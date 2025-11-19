package com.example.rick_mortyy.data.models


import com.google.gson.annotations.SerializedName

data class OriginDto(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("url")
    val url: String? = null
)