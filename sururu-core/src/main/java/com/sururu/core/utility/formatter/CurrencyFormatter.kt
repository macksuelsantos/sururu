package com.sururu.core.utility.formatter

import java.util.Formatter
import java.util.Locale

object CurrencyFormatter {

    private var formatter: Formatter? = null

    /**

     * @param value = 1000
     * *
     * @return = 1,000.00
     */
    fun format(value: Double): String {
        val sb = StringBuilder()
        formatter = Formatter(sb, Locale.US)
        formatter!!.format("%,.2f", value)
        return sb.toString()
    }
}
