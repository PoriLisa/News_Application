package com.lissa.newsapplication.networking

import com.lissa.newsapplication.model.Articles
import com.lissa.newsapplication.model.ArticlesItem

sealed class NetworkUiState {

    data class Success(var news: List<ArticlesItem>): NetworkUiState()
    data class Error(var exception: Throwable): NetworkUiState()
    data class Loading(var loading: String ): NetworkUiState()



}
