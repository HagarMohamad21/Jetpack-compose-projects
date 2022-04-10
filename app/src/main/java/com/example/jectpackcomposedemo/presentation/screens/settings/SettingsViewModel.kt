package com.example.jectpackcomposedemo.presentation.screens.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jectpackcomposedemo.data.datastore.PrefStore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SettingsViewModel @Inject constructor(private val prefStore: PrefStore):ViewModel() {

     fun savePref(value:String){
         viewModelScope.launch(Dispatchers.IO) {
             prefStore.editDegreeUnit(value)
         }
    }
    fun getUnitFromDataStore()=
        prefStore.getDegreeUnit()

}