package com.example.jectpackcomposedemo.utils

data class DataOrException<T,Boolean,E:kotlin.Exception>(
    var data:T?=null,
    var loading:kotlin.Boolean?=null,
    var e:E?=null
) {
}