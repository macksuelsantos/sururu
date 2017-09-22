package com.sururu.core.activity

import android.content.Intent

interface IResultCallbackActivity {

    fun onResultOk(data: Intent)

    fun onResultCancel(data: Intent)
}
