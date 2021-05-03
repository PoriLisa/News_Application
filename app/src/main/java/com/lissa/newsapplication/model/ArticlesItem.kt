package com.lissa.newsapplication.model


import com.google.gson.annotations.SerializedName

data class ArticlesItem(
    @SerializedName("events")
    var events: List<Event>,
    @SerializedName("featured")
    var featured: Boolean,
    @SerializedName("id")
    var id: String,
    @SerializedName("imageUrl")
    var imageUrl: String,
    @SerializedName("launches")
    var launches: List<Launch>,
    @SerializedName("newsSite")
    var newsSite: String,
    @SerializedName("publishedAt")
    var publishedAt: String,
    @SerializedName("summary")
    var summary: String,
    @SerializedName("title")
    var title: String,
    @SerializedName("updatedAt")
    var updatedAt: String,
    @SerializedName("url")
    var url: String
) {
    override fun toString(): String {
        return "ArticlesItem(events=$events, featured=$featured, id='$id', imageUrl='$imageUrl', launches=$launches, newsSite='$newsSite', publishedAt='$publishedAt', summary='$summary', title='$title', updatedAt='$updatedAt', url='$url')"
    }
}