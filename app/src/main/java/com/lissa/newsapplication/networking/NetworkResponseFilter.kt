package com.lissa.newsapplication.networking

import retrofit2.Response

object NetworkResponseFilter {
    inline fun  <T> getResponse(
        response: NetworkUiStateDetails<T>,
        success: (T) -> Unit,
        error: (String) -> Unit,
        loading:()->Unit
    ) {
        when(response){

            is NetworkUiStateDetails.Success -> success(response.data)
            is NetworkUiStateDetails.Error -> error(response.error)

        }
    }

    inline fun <reified T> getNetworkState(response: Response<T>):NetworkUiStateDetails<T>{
        return try {
            if (response.isSuccessful){
                NetworkUiStateDetails.Success(response.body()!!)
            }else{
                when(response.code()){
                    403,404,500,502,301,3012 -> NetworkUiStateDetails.NetworkException(response.message())
                    else ->  NetworkUiStateDetails.Error(response.message())
                }
            }
        }catch (error : Exception){
            NetworkUiStateDetails.NetworkException(error.message ?: "")
        }

    }
}