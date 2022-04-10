package com.example.jectpackcomposedemo.data.datastore

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.preferencesKey
import androidx.datastore.preferences.createDataStore
import com.example.jectpackcomposedemo.utils.Constants
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PrefStoreImpl @Inject constructor(@ApplicationContext context: Context):PrefStore {

    val dataStore=context.createDataStore(name = "Settings")

    override suspend fun editDegreeUnit(value:String) {
      dataStore.edit {
          it[DataStoreKeys.SETTINGS_KEY]=value
      }
    }

    override  fun getDegreeUnit() =
        dataStore.data.map {
         it[DataStoreKeys.SETTINGS_KEY]?:Constants.IMPERIAL
        }



}

object DataStoreKeys{
     val SETTINGS_KEY= preferencesKey<String>( "settings")
}