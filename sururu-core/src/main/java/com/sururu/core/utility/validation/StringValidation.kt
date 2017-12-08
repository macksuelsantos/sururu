package com.sururu.core.utility.validation

class StringValidation {

    companion object {
        fun isEmpty(value: String): Boolean {
            return isNull(value) || "" == value.trim { it <= ' ' }
        }

        fun isNotEmpty(value: String): Boolean {
            return !isEmpty(value)
        }

        fun isNull(value: String?): Boolean {
            return value == null
        }

        fun isNotNull(value: String?): Boolean {
            return value != null
        }

        fun isValidEmail(target: CharSequence?): Boolean {
            return !(target == null || isEmpty(target.toString())) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches()
        }
    }
}
