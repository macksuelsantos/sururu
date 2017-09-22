package com.sururu.core.utility

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

object Utility {

    fun hideKeyboard(mActivity: Activity?, view: View?) {
        if (mActivity != null) {
            val inputManager = mActivity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            if (view != null)
                inputManager.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}
