package com.sururu.restclient

import android.util.Log
import com.sururu.restclient.handler.RequestHandler
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Created by macksuelsantos on 8/11/17.
 */

abstract class RestClient {

    open fun createRetrofit(): Retrofit {
        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(getBaseUrl)
                .build()
    }

    open fun create(clazz: Class<*>): Any {
        return createRetrofit().create(clazz)
    }

    open fun <T> request(call: Call<T>, handler: RequestHandler<T>) {
        val callback = object : Callback<T> {
            override fun onResponse(c: Call<T>, response: Response<T>) {
                if (response.isSuccessful) {
                    handler.onSuccess(response.body()!!)
                } else {
                    handler.onFail(response.errorBody())
                }

                Log.i("Request:", c.request().url().toString())
            }

            override fun onFailure(c: Call<T>, throwable: Throwable) {
                handler.onFail(throwable)
            }
        }

        call.enqueue(callback)
    }

    protected abstract val getBaseUrl: String

}