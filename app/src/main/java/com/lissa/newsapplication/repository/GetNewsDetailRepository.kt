package com.lissa.newsapplication.repository

import android.util.Log
import com.lissa.newsapplication.model.ArticlesDetails
import com.lissa.newsapplication.model.ArticlesItem
import com.lissa.newsapplication.networking.RetrofitBuilder
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

object GetNewsDetailRepository {

    private const val TAG = "LanguageRep0"
    private val restClient = RetrofitBuilder()
    private val apiInterface = restClient.apiService


    fun getArticlesDetails(articlesId: String): Flow<Response<ArticlesDetails>> = flow {
        val result = apiInterface.getArticlesDetails(articlesId)
        emit(result)
        Log.e(TAG, "getArticlesDetails: "+result )
    }
}