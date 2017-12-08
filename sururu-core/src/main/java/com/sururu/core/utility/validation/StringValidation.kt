package com.sururu.core.utility.validation

class StringValidation {

    open fun isEmpty(value: String): Boolean {
        return isNull(value) || "" == value.trim { it <= ' ' }
    }

    open fun isNotEmpty(value: String): Boolean {
        return !isEmpty(value)
    }

    open fun isNull(value: String?): Boolean {
        return value == null
    }

    open fun isNotNull(value: String?): Boolean {
        return value != null
    }

    open fun isValidEmail(target: CharSequence?): Boolean {
        return !(target == null || isEmpty(target.toString())) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches()
    }
}
