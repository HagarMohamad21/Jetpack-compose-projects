package com.example.jectpackcomposedemo.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jectpackcomposedemo.domain.model.Note
import com.example.jectpackcomposedemo.presentation.NoteScreen
import com.example.jectpackcomposedemo.presentation.note.NoteDetailsScreen
import com.example.jectpackcomposedemo.utils.requiredArg

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NoteNavigation(onNoteAdded:(note: Note)->Unit,onNoteRemoved:(note:Note)->Unit,noteList:List<Note>) {

    val navController= rememberNavController()

    val navHost= NavHost(navController = navController, startDestination = NoteScreens.NoteScreen.name)

    {

     composable(route =NoteScreens.NoteScreen.name){
         NoteScreen(notes = noteList, onAddNote = onNoteAdded, onRemoveNote =onNoteRemoved, navController = navController)
     }
    composable(route = NoteScreens.NoteDetailsScreen.name){

        navBackStackEntry ->
        NoteDetailsScreen( navController =navController,navBackStackEntry.requiredArg<Note>("noteDetails"))
    }

    }

}