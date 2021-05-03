package com.lissa.newsapplication.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Event(
    @SerializedName("id")

    var id: String,
    @SerializedName("provider")

    var provider: String
)
