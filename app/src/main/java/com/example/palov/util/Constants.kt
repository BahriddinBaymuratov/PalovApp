package com.example.palov.util

import org.jsoup.Jsoup

fun String.toCleanString(): String {
    val jsoup = Jsoup.parse(this)
    return jsoup.text()
}