package com.example.jectpackcomposedemo.navigation

enum class NoteScreens {
    NoteScreen,
    NoteDetailsScreen;
    companion object{
        fun fromRoute(route:String?=null){
            when(route?.substringBefore("/")){
                NoteScreen.name->NoteScreen
                NoteDetailsScreen.name->NoteDetailsScreen
                null->NoteScreen
               else -> throw IllegalStateException("Route $route is not recognized")
            }
        }
    }
}