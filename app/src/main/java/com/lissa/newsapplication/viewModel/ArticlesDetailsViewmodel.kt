package com.lissa.newsapplication.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lissa.newsapplication.model.ArticlesDetails
import com.lissa.newsapplication.networking.NetworkResponseFilter
import com.lissa.newsapplication.networking.NetworkUiState
import com.lissa.newsapplication.networking.NetworkUiStateDetails
import com.lissa.newsapplication.repository.GetNewsDetailRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ArticlesDetailsViewmodel():ViewModel(){



    private val _uiState =
        MutableStateFlow<NetworkUiStateDetails<ArticlesDetails>>(NetworkUiStateDetails.Loading)
    val uiState: StateFlow<NetworkUiStateDetails<ArticlesDetails>> = _uiState
    fun getDetailsScreen(articlesId: String?) {


        viewModelScope.launch {

            GetNewsDetailRepository.getArticlesDetails(articlesId!!).collect {


                _uiState.value = NetworkResponseFilter.getNetworkState(it)


            }
        }
    }

}