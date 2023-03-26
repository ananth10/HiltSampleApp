package com.ananth.hiltsampleapp.network

import javax.inject.Inject

class ResponseInterceptorImpl @Inject constructor() :Interceptor {

    override fun log(message: String) {
        println("This is the response interceptor:$message")
    }
}