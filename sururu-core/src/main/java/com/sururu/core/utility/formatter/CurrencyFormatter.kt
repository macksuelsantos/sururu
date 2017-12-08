package com.sururu.core.utility.formatter

import java.util.*

class CurrencyFormatter {

    companion object {
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
}
