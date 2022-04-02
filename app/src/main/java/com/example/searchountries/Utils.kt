package com.example.searchountries

import android.icu.text.NumberFormat
import java.util.*

fun languagesToString(languages: List<Language>): String{
    return languages.joinToString { it.name }
}
fun formatNumber(number: Long): String{
//    val numToStr: String = java.lang.String.format(Locale.US, "%,d", number)
    val numToStr = NumberFormat.getInstance().format(number)
    return numToStr
}