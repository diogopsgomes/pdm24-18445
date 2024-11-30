package com.example.articles.utils

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
fun dateTimeToString(dateTime: String): String {
    return ZonedDateTime.parse(dateTime, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ")).format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))
}