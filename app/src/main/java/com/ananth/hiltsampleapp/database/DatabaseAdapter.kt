package com.ananth.hiltsampleapp.database

import android.content.Context
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

//Constructor injection
class DatabaseAdapter @Inject constructor(@ActivityContext private val context: Context,var databaseService: DatabaseService) {

    fun log(message: String) {
        println("Database adapter:$message")
        println("Context available:$context")
        databaseService.log(message)
    }
}