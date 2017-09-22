package com.sururu.core.activity

import android.app.Service
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.support.annotation.AnimRes
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.sururu.core.R
import com.sururu.core.component.delegate.IStartActivityDelegate
import com.sururu.core.component.delegate.StartActivityDelegate
import com.sururu.core.component.delegate.adaptor.StartActivityAdaptor

abstract class AbstractSururuActivity : AppCompatActivity(), IStartActivityDelegate {

    private var mStartActivityDelegate: IStartActivityDelegate? = null

    override fun onCreate(arg0: Bundle?) {
        super.onCreate(arg0)

        mStartActivityDelegate = StartActivityDelegate(StartActivityAdaptor(this))
    }

    override fun pushActivity(screen: Class<*>) {
        mStartActivityDelegate!!.pushActivity(screen)
    }

    override fun pushActivity(screen: Class<*>, extras: Bundle) {
        mStartActivityDelegate!!.pushActivity(screen, extras)
    }

    override fun popActivity(screen: Class<*>) {
        mStartActivityDelegate!!.popActivity(screen)
    }

    override fun popActivity(screen: Class<*>, extras: Bundle) {
        mStartActivityDelegate!!.popActivity(screen, extras)
    }

    override fun pushActivityWithAnimationSettingFlagClearTop(clazz: Class<*>) {
        mStartActivityDelegate!!.goToActivityWithAnimationSettingFlagClearTop(clazz, R.anim.slide_left_enter, R.anim.slide_left_exit)
    }

    override fun goToActivity(screen: Class<*>) {
        mStartActivityDelegate!!.goToActivity(screen)
    }

    override fun reorderActivityToFront(screen: Class<*>, extras: Bundle) {
        mStartActivityDelegate!!.reorderActivityToFront(screen, extras)
    }

    override fun goToActivityWithAnimation(screen: Class<*>, @AnimRes enterAnim: Int, @AnimRes exitAnim: Int) {
        mStartActivityDelegate!!.goToActivityWithAnimation(screen, enterAnim, exitAnim)
    }

    override fun goToActivityWithAnimation(screen: Class<*>, extras: Bundle, @AnimRes enterAnim: Int, @AnimRes exitAnim: Int) {
        mStartActivityDelegate!!.goToActivityWithAnimation(screen, extras, enterAnim, exitAnim)
    }

    override fun goToActivityWithNoAnimation(screen: Class<*>) {
        mStartActivityDelegate!!.goToActivityWithNoAnimation(screen)
    }

    override fun goToActivityWithNoAnimation(screen: Class<*>, extras: Bundle) {
        mStartActivityDelegate!!.goToActivityWithNoAnimation(screen, extras)
    }

    override fun goToActivityWithAnimationSettingFlagClearTop(screen: Class<*>, @AnimRes enterAnim: Int, @AnimRes exitAnim: Int) {
        mStartActivityDelegate!!.goToActivityWithAnimationSettingFlagClearTop(screen, enterAnim, exitAnim)
    }

    override fun goToActivity(action: String) {
        mStartActivityDelegate!!.goToActivity(action)
    }

    override fun openBrowser(url: String) {
        mStartActivityDelegate!!.openBrowser(url)
    }

    override fun launchSubActivity(subActivityClass: Class<*>, callback: IResultCallbackActivity) {
        mStartActivityDelegate!!.launchSubActivity(subActivityClass, callback)
    }

    override fun launchSubActivity(i: Intent, callback: IResultCallbackActivity) {
        mStartActivityDelegate!!.launchSubActivity(i, callback)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)

        mStartActivityDelegate!!.onActivityResult(requestCode, resultCode, data)
    }

    override fun startService(cl: Class<*>) {
        mStartActivityDelegate!!.startService(cl)
    }

    override fun stopService(cl: Class<*>) {
        mStartActivityDelegate!!.stopService(cl)
    }

    override fun bindService(service: Service, serviceClass: Class<*>, serviceConnection: ServiceConnection) {
        mStartActivityDelegate!!.bindService(service, serviceClass, serviceConnection)
    }

    protected fun replaceFragment(fragmentId: Int, fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(fragmentId, fragment).commit()
    }

    protected fun replaceFragment(fragmentId: Int, fragment: Fragment, tag: String) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(fragmentId, fragment, tag).commit()
    }

}
