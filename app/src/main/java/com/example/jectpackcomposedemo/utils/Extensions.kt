package com.example.jectpackcomposedemo.utils

//suspend fun <T : Any> handleResult(callApi: suspend () -> NetworkResponse<T, ApiErrorResponse>): Result<T> {
//    return when (val response = callApi()) {
//        is NetworkResponse.Success -> Result.success(response.body)
//        is NetworkResponse.ServerError -> Result.failure(response.body!!)
//        is NetworkResponse.NetworkError -> Result.failure(response.error)
//        is NetworkResponse.UnknownError -> Result.failure(response.error)
//    }
//}