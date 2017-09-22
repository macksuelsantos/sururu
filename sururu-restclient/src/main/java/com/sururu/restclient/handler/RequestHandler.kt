package com.sururu.restclient.handler

import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import okhttp3.ResponseBody
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader


/**
 * Created by macksuelsantos on 8/11/17.
 */
open class RequestHandler<in T>(private val context: Context) : Handler<T> {

    private var progressDialog: ProgressDialog? = null

    init {
        createProgressDialog()
    }

    private fun createProgressDialog() {
        if (progressDialog == null) {
            progressDialog = ProgressDialog(context)
            progressDialog?.setMessage("Please wait...")
            progressDialog?.setCancelable(false)
            progressDialog?.show()
        }
    }

    override fun onSuccess(response: T) {
        progressDialog?.dismiss()
    }

    override fun onFail(error: Throwable) {
        progressDialog?.dismiss()
    }

    fun onFail(responseBody: ResponseBody?) {
        progressDialog?.dismiss()

        val reader: BufferedReader?
        try {
            reader = BufferedReader(InputStreamReader(responseBody?.byteStream()))
            Toast.makeText(context, reader.readLine(), Toast.LENGTH_SHORT).show()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    fun getMessage(error: Throwable): String? {
        try {
            return error.message
        } catch (ignored: Exception) {}

        return ""
    }

}