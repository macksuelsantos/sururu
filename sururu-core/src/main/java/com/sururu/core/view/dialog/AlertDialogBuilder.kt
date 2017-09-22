package com.sururu.core.view.dialog

import android.app.AlertDialog
import android.content.Context
import android.support.annotation.IdRes
import android.support.annotation.StringRes

import com.sururu.core.R

class AlertDialogBuilder(private val mContext: Context) {

    fun showAlertDialog(title: String, message: String) {
        createAlertDialog(title, message).show()
    }

    fun showAlertDialog(title: Int, message: Int) {
        createAlertDialog(title, message).show()
    }

    fun showSuccessMessage(message: String) {
        createAlertDialog(mContext.getString(R.string.success), message).show()
    }

    fun showErrorMessage(message: String) {
        createAlertDialog(mContext.getString(R.string.error), message).show()
    }

    fun showErrorMessage(messageId: Int) {
        showErrorMessage(mContext.getString(messageId))
    }

    private fun createAlertDialog(title: String, message: String): AlertDialog {
        val builder = AlertDialog.Builder(mContext)
        builder.setMessage(message)
                .setTitle(title)
                .setPositiveButton(R.string.ok, null)

        return builder.create()
    }

    private fun createAlertDialog(@StringRes title: Int, @StringRes message: Int): AlertDialog {
        val builder = AlertDialog.Builder(mContext)
        builder.setMessage(message)
                .setTitle(title)
                .setPositiveButton(R.string.ok, null)

        return builder.create()
    }

}