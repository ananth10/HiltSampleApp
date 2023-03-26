package com.ananth.hiltsampleapp.network

import javax.inject.Inject

class CallInterceptorImpl @Inject constructor():Interceptor {

    override fun log(message: String) {
       println("This is a call interceptor: $message")
    }
}