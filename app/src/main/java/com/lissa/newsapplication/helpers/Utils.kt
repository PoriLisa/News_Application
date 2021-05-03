package com.lissa.newsapplication.helpers

import android.widget.TextView
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

object Utils {
    fun convertISOTimeToDate( isoTime: String): String? {
        val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS")
        var convertedDate: Date? = null
        var formattedDate: String? = null
        try {
            convertedDate = sdf.parse(isoTime)
            formattedDate = SimpleDateFormat("dd-MMM-yyyy").format(convertedDate)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        return formattedDate
    }
}