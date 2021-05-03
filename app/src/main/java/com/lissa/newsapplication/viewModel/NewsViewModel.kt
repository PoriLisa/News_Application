package com.lissa.newsapplication.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lissa.newsapplication.model.Articles
import com.lissa.newsapplication.model.ArticlesItem
import com.lissa.newsapplication.networking.NetworkResponseFilter
import com.lissa.newsapplication.networking.NetworkUiState
import com.lissa.newsapplication.repository.GetNewsListRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class NewsViewModel() : ViewModel() {


    private val _uiState = MutableStateFlow(NetworkUiState.Success(emptyList()))
    // The UI collects from this StateFlow to get its state updates
    val uiState: StateFlow<NetworkUiState> = _uiState

    fun getNewsList() {
        viewModelScope.launch {

            GetNewsListRepository.getArticles().collect {


                    _uiState.value = NetworkUiState.Success(it)


            }
        }
    }

}