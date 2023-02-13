package com.neoapp.noteapplicationcompose.util

import java.text.SimpleDateFormat
import java.util.*
import java.util.logging.SimpleFormatter

fun formatDate(time : Long):String{
    val date = Date(time)
    val format = SimpleDateFormat("EEE, d MMM hh:mm aaa" , Locale.getDefault())
    return format.format(date)
}