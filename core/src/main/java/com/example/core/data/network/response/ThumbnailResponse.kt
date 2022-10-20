package com.example.core.data.network.response

data class ThumbnailResponse(
    val path: String,

    // @SerializedName("extension") - caso precise mapear nome de atributo diferente
    val extensionPath: String
)
