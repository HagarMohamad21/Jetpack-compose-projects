package com.example.jectpackcomposedemo.data.datastore

import kotlinx.coroutines.flow.Flow


interface PrefStore{

    suspend fun editDegreeUnit(value:String)

     fun getDegreeUnit(): Flow<String>


}
