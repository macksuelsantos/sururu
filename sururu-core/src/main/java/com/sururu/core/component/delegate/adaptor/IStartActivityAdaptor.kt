package com.sururu.core.component.delegate.adaptor

import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.support.annotation.AnimRes

interface IStartActivityAdaptor {

    val context: Context

    fun startActivity(intent: Intent)

    fun overridePendingTransition(@AnimRes enterAnim: Int, @AnimRes exitAnim: Int)

    fun startActivityForResult(intent: Intent, requestCode: Int)

    fun startService(service: Intent)

    fun stopService(service: Intent)

    fun bindService(service: Intent, conn: ServiceConnection, flags: Int)

}
