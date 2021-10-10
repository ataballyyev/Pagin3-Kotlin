package com.example.paing3kotlin.data

import com.squareup.moshi.Json

data class Ad(
    @Json(name = "company")
    val company: String,
    @Json(name = "text")
    val text: String,
    @Json(name = "url")
    val url: String
)
