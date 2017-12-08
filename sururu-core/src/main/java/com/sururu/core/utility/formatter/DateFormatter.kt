package com.sururu.core.utility.formatter

import java.text.SimpleDateFormat
import java.util.Locale

class DateFormatter {

    open fun getDayWithSuffix(day: Int): CharSequence {
        if (day in 1..31) {
            if (day in 11..13) {
                return day.toString() + "th"
            }

            when (day % 10) {
                1 -> return day.toString() + "st"
                2 -> return day.toString() + "nd"
                3 -> return day.toString() + "rd"
                else -> return day.toString() + "th"
            }
        }

        throw IllegalArgumentException("The day of the month should be between 1 and 31.")
    }

    open fun simpleDateFormat(pattern: String): SimpleDateFormat {
        try {
            return SimpleDateFormat(pattern, Locale.getDefault())
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException("Pattern invalid date.")
        }

    }
}