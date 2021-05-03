package com.lissa.newsapplication.networking

import com.lissa.newsapplication.model.ArticlesDetails
import com.lissa.newsapplication.model.ArticlesItem

sealed class NetworkUiStateDetails<out T> {
    data class Success <T>(val data : T) : NetworkUiStateDetails<T>()
    /*data class Success(var news: ArticlesDetails) : NetworkUiStateDetails()*/
    data class Error(val error : String) : NetworkUiStateDetails<Nothing>()
    object Loading : NetworkUiStateDetails<Nothing>()
    data class NetworkException(val error : String) : NetworkUiStateDetails<Nothing>()

}
