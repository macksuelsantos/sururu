package com.sururu.restclient.handler


/**
 * Created by macksuelsantos on 8/11/17.
 */
interface Handler<in T> {
    fun onSuccess(response: T)

    fun onFail(error: Throwable)
}