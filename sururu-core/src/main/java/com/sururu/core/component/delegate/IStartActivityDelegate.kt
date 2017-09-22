package com.sururu.core.component.delegate

import android.app.Service
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.support.annotation.AnimRes

import com.sururu.core.activity.IResultCallbackActivity

/**
 * @author Jairo Barros Junior (jairobjunior@gmail.com)
 * *
 * @since May 9, 2013
 */
interface IStartActivityDelegate {

    fun goToActivity(screen: Class<*>)

    fun pushActivity(screen: Class<*>)

    fun pushActivity(screen: Class<*>, extras: Bundle)

    fun pushActivityWithAnimationSettingFlagClearTop(clazz: Class<*>)

    fun popActivity(screen: Class<*>)

    fun popActivity(screen: Class<*>, extras: Bundle)

    fun goToActivityWithNoAnimation(screen: Class<*>)

    fun goToActivityWithAnimation(screen: Class<*>, @AnimRes enterAnim: Int, @AnimRes exitAnim: Int)

    fun goToActivityWithAnimation(screen: Class<*>, extras: Bundle, @AnimRes enterAnim: Int, @AnimRes exitAnim: Int)

    fun goToActivityWithAnimationSettingFlagClearTop(screen: Class<*>, @AnimRes enterAnim: Int, @AnimRes exitAnim: Int)

    fun goToActivity(action: String)

    fun reorderActivityToFront(screen: Class<*>, extras: Bundle)

    fun goToActivityWithNoAnimation(screen: Class<*>, extras: Bundle)

    fun openBrowser(url: String)

    fun launchSubActivity(subActivityClass: Class<*>, callback: IResultCallbackActivity)

    fun launchSubActivity(i: Intent, callback: IResultCallbackActivity)

    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent)

    fun startService(cl: Class<*>)

    fun stopService(cl: Class<*>)

    fun bindService(service: Service, serviceClass: Class<*>, serviceConnection: ServiceConnection)
}
