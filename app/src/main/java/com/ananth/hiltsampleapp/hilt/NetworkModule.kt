package com.ananth.hiltsampleapp.hilt

import com.ananth.hiltsampleapp.network.*
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
class NetworkModule {

//    @Binds
//    abstract fun bindNetworkAdapterImpl(networkAdapterImpl:MyAppNetworkAdapter) : NetworkAdapter

//    @Provides
//    fun provideNetworkService(): NetworkService {
//        return NetworkService.Builder()
//            .host("google.com")
//            .path("my path")
//            .protocol("HTTPS")
//            .build()
//    }

    @ActivityScoped
    @CallInterceptor
     @Provides
     fun callNetworkService():NetworkService{
         return NetworkService.Builder()
             .host("google.com")
             .protocol("HTTPS")
             .interceptor(CallInterceptorImpl())
             .build()
     }

    @ActivityScoped
    @ResponseInterceptor
    @Provides
    fun provideNetworkService():NetworkService{
        return NetworkService.Builder()
            .host("google.com")
            .protocol("HTTPS")
            .interceptor(ResponseInterceptorImpl())
            .build()
    }
}