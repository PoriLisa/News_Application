package com.lissa.newsapplication.repository

import com.lissa.newsapplication.model.Articles
import com.lissa.newsapplication.model.ArticlesItem
import com.lissa.newsapplication.networking.RetrofitBuilder
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

object GetNewsListRepository {

    private const val TAG = "LanguageRep0"
    private val restClient = RetrofitBuilder()
    private val apiInterface = restClient.apiService


    fun getArticles(): Flow<List<ArticlesItem>> = flow {
        val result = apiInterface.getArticles()
        emit(result)
    }
}