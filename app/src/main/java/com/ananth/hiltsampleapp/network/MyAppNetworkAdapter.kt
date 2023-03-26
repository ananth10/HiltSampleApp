package com.ananth.hiltsampleapp.network

import javax.inject.Inject

class MyAppNetworkAdapter @Inject constructor():NetworkAdapter {
    override fun log(message: String) {
        println("MyNetwork Adapter:$message")
    }
}