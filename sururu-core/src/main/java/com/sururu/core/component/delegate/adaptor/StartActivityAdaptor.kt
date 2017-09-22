package com.sururu.core.component.delegate.adaptor

import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.support.annotation.AnimRes
import android.support.v7.app.AppCompatActivity

class StartActivityAdaptor(private val mActivity: AppCompatActivity) : IStartActivityAdaptor {

    override val context: Context
        get() = mActivity

    override fun startActivity(intent: Intent) {
        mActivity.startActivity(intent)
    }

    override fun overridePendingTransition(@AnimRes enterAnim: Int, @AnimRes exitAnim: Int) {
        mActivity.overridePendingTransition(enterAnim, exitAnim)
    }

    override fun startActivityForResult(intent: Intent, requestCode: Int) {
        mActivity.startActivityForResult(intent, requestCode)
    }

    override fun startService(service: Intent) {
        mActivity.startService(service)
    }

    override fun stopService(service: Intent) {
        mActivity.stopService(service)
    }

    override fun bindService(service: Intent, conn: ServiceConnection, flags: Int) {
        mActivity.bindService(service, conn, flags)
    }

}
