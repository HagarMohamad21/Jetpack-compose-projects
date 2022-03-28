package com.example.jectpackcomposedemo.utils

import java.text.SimpleDateFormat
import java.util.*


fun formatDate(timeStamp:Int):String{
    val sdf=SimpleDateFormat("EEE, MMM d")
    val date= Date(timeStamp.toLong()*1000)
    return sdf.format(date)
}


fun formatDateTime(timeStamp: Int):String{
    val sdf=SimpleDateFormat("hh:mm aa")
    val date=Date(timeStamp.toLong() * 1000)
    return sdf.format(date)
}
fun formatDateDay(timeStamp: Int):String{
    val sdf=SimpleDateFormat("EEE")
    val date=Date(timeStamp.toLong() * 1000)
    return sdf.format(date)
}

fun formatTempDegree(temp:Double):String{
    val formattedTemp="%.0f".format(temp)
    return "$formattedTemp°"
}