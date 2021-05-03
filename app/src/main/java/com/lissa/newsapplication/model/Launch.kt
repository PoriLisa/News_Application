package com.lissa.newsapplication.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Launch(
    @SerializedName("id")
    @Expose
    var id: String,
    @SerializedName("provider")
    @Expose
    var provider: String
)
