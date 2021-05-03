package com.lissa.newsapplication.networking

import com.lissa.newsapplication.model.Articles
import com.lissa.newsapplication.model.ArticlesDetails
import com.lissa.newsapplication.model.ArticlesItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface ApiService {

    @GET("v2/articles")
    suspend fun getArticles(): List<ArticlesItem>

    @GET("v2/articles/{id}")
    suspend fun getArticlesDetails( @Path("id") id: String): Response<ArticlesDetails>
}