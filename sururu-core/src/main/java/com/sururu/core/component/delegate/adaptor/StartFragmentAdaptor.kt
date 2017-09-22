package com.sururu.core.component.delegate.adaptor

import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.support.annotation.AnimRes
import android.support.v4.app.Fragment

class StartFragmentAdaptor(private val mFragment: Fragment) : IStartActivityAdaptor {

    override val context: Context
        get() = mFragment.activity

    override fun startActivity(intent: Intent) {
        mFragment.startActivity(intent)
    }

    override fun overridePendingTransition(@AnimRes enterAnim: Int, @AnimRes exitAnim: Int) {
        mFragment.activity.overridePendingTransition(enterAnim, exitAnim)
    }

    override fun startActivityForResult(intent: Intent, requestCode: Int) {
        mFragment.startActivityForResult(intent, requestCode)
    }

    override fun startService(intent: Intent) {
        mFragment.activity.startService(intent)
    }

    override fun stopService(intent: Intent) {
        mFragment.activity.stopService(intent)
    }

    override fun bindService(service: Intent, conn: ServiceConnection, flags: Int) {
        mFragment.activity.bindService(service, conn, flags)
    }

}
