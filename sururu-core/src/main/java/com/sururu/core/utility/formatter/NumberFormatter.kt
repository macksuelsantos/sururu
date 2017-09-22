package com.sururu.core.utility.formatter

import java.math.RoundingMode
import java.text.DecimalFormat
import java.text.NumberFormat

object NumberFormatter {

    fun formatDecimalWithTwoMaximumFractionDigits(value: Double): CharSequence {
        val df = DecimalFormat.getInstance()
        df.maximumFractionDigits = 2
        df.roundingMode = RoundingMode.DOWN
        return df.format(value)
    }

    fun getAbsNumberWithFormat(value: Double): CharSequence {
        val nf = NumberFormat.getInstance()
        val absValue = Math.abs(value)
        return nf.format(absValue)
    }
}
