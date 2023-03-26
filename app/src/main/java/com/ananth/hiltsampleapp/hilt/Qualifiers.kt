package com.ananth.hiltsampleapp.hilt

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class CallInterceptor {
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ResponseInterceptor{

}