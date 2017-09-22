package com.sururu.core.component.delegate

import android.app.Activity
import android.app.Service
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.net.Uri
import android.os.Bundle
import android.support.annotation.AnimRes
import android.util.Log
import android.util.SparseArray
import com.sururu.core.R
import com.sururu.core.activity.IResultCallbackActivity
import com.sururu.core.component.delegate.adaptor.IStartActivityAdaptor
import java.util.*

/**
 * @author Jairo Barros Junior (jairobjunior@gmail.com)
 * *
 * @since May 9, 2013
 */
class StartActivityDelegate(private val mStartActivityAdaptor: IStartActivityAdaptor) : IStartActivityDelegate {

    private val TAG = "StartActivityDelegate"

    val mCallbackMap: SparseArray<IResultCallbackActivity> = SparseArray()

    override fun goToActivity(screen: Class<*>) {
        val intent = Intent(mStartActivityAdaptor.context, screen)
        mStartActivityAdaptor.startActivity(intent)
    }

    override fun reorderActivityToFront(screen: Class<*>, extras: Bundle) {
        val intent = Intent(mStartActivityAdaptor.context, screen)
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
        intent.putExtras(extras)
        mStartActivityAdaptor.startActivity(intent)
    }

    override fun goToActivityWithNoAnimation(screen: Class<*>) {
        goToActivityWithAnimation(screen, 0, 0)
    }

    override fun goToActivityWithNoAnimation(screen: Class<*>, extras: Bundle) {
        goToActivityWithAnimation(screen, extras, 0, 0)
    }

    override fun goToActivityWithAnimation(screen: Class<*>, @AnimRes enterAnim: Int, @AnimRes exitAnim: Int) {
        goToActivity(screen)
        mStartActivityAdaptor.overridePendingTransition(enterAnim, exitAnim)
    }

    override fun goToActivityWithAnimation(screen: Class<*>, extras: Bundle, @AnimRes enterAnim: Int, @AnimRes exitAnim: Int) {
        val intent = Intent(mStartActivityAdaptor.context, screen)
        intent.putExtras(extras)
        mStartActivityAdaptor.startActivity(intent)
        mStartActivityAdaptor.overridePendingTransition(enterAnim, exitAnim)
    }


    override fun goToActivityWithAnimationSettingFlagClearTop(screen: Class<*>, @AnimRes enterAnim: Int, @AnimRes exitAnim: Int) {
        val intent = Intent(mStartActivityAdaptor.context, screen)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        mStartActivityAdaptor.startActivity(intent)
        mStartActivityAdaptor.overridePendingTransition(enterAnim, exitAnim)
    }

    override fun goToActivity(action: String) {
        val intent = Intent(action)
        mStartActivityAdaptor.startActivity(intent)
    }

    override fun openBrowser(url: String) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        mStartActivityAdaptor.startActivity(browserIntent)
    }

    override fun launchSubActivity(subActivityClass: Class<*>, callback: IResultCallbackActivity) {
        val i = Intent(mStartActivityAdaptor.context, subActivityClass)

        launchSubActivity(i, callback)
    }

    override fun launchSubActivity(i: Intent, callback: IResultCallbackActivity) {
        val correlationId = Random().nextInt(9999)

        mCallbackMap.put(correlationId, callback)
        mStartActivityAdaptor.startActivityForResult(i, correlationId)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        try {
            val callback = mCallbackMap.get(requestCode)

            when (resultCode) {
                Activity.RESULT_CANCELED -> {
                    callback.onResultCancel(data)
                    mCallbackMap.remove(requestCode)
                }
                Activity.RESULT_OK -> {
                    callback.onResultOk(data)
                    mCallbackMap.remove(requestCode)
                }
                else -> Log.e(TAG, "Couldn't find callback handler for correlationId")
            }
        } catch (e: Exception) {
            Log.e(TAG, "Problem processing result from sub-activity", e)
        }

    }

    override fun startService(cl: Class<*>) {
        val i = Intent(mStartActivityAdaptor.context, cl)
        mStartActivityAdaptor.startService(i)
    }

    override fun stopService(cl: Class<*>) {
        val i = Intent(mStartActivityAdaptor.context, cl)
        mStartActivityAdaptor.stopService(i)
    }

    override fun bindService(service: Service, serviceClass: Class<*>,
                             serviceConnection: ServiceConnection) {
        Log.d(TAG, "Binding Service: " + serviceClass.name)
        mStartActivityAdaptor.bindService(Intent(mStartActivityAdaptor.context, serviceClass), serviceConnection,
                Context.BIND_AUTO_CREATE)
    }

    override fun pushActivity(screen: Class<*>) {
        goToActivityWithAnimation(screen, R.anim.slide_left_enter, R.anim.slide_left_exit)
    }

    override fun pushActivity(screen: Class<*>, extras: Bundle) {
        goToActivityWithAnimation(screen, extras, R.anim.slide_left_enter, R.anim.slide_left_exit)
    }

    override fun popActivity(screen: Class<*>) {
        goToActivityWithAnimation(screen, R.anim.slide_right_enter, R.anim.slide_right_exit)
    }

    override fun popActivity(screen: Class<*>, extras: Bundle) {
        goToActivityWithAnimation(screen, extras, R.anim.slide_right_enter, R.anim.slide_right_exit)
    }

    override fun pushActivityWithAnimationSettingFlagClearTop(clazz: Class<*>) {
        goToActivityWithAnimationSettingFlagClearTop(clazz, R.anim.slide_left_enter, R.anim.slide_left_exit)
    }

}