package com.lissa.newsapplication.model


import com.google.gson.annotations.SerializedName

data class ArticlesDetails(
    @SerializedName("events")
    val events: List<Event>,
    @SerializedName("featured")
    val featured: Boolean,
    @SerializedName("imageUrl")
    val imageUrl: String,
    @SerializedName("launches")
    val launches: List<Launch>,
    @SerializedName("newsSite")
    val newsSite: String,
    @SerializedName("publishedAt")
    val publishedAt: String,
    @SerializedName("summary")
    val summary: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("updatedAt")
    val updatedAt: String,
    @SerializedName("url")
    val url: String
) {
    override fun toString(): String {
        return "ArticlesDetails(events=$events, featured=$featured, imageUrl='$imageUrl', launches=$launches, newsSite='$newsSite', publishedAt='$publishedAt', summary='$summary', title='$title', updatedAt='$updatedAt', url='$url')"
    }
}