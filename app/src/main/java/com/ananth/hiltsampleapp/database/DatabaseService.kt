package com.ananth.hiltsampleapp.database

import com.ananth.hiltsampleapp.util.AppLog
import javax.inject.Inject

class DatabaseService @Inject constructor() {

    fun log(message:String){
        AppLog.debug("Database service message:$message}")
    }
}