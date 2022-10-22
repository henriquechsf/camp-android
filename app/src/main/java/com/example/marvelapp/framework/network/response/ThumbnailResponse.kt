package com.example.marvelapp.framework.network.response

data class ThumbnailResponse(
    val path: String,

    // @SerializedName("extension") - caso precise mapear nome de atributo diferente
    val extension: String
)
