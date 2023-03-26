package com.ananth.hiltsampleapp

import android.content.Context
import com.ananth.hiltsampleapp.database.DatabaseAdapter
import com.ananth.hiltsampleapp.database.DatabaseService
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import java.io.ByteArrayOutputStream
import java.io.PrintStream

@RunWith(MockitoJUnitRunner::class)
class DatabaseAdapterTest {

    @Mock
    lateinit var context:Context

    @Mock
    lateinit var databaseService: DatabaseService

    @Test
    fun testDatabaseAdapter(){
        var adapter = DatabaseAdapter(context,databaseService)

        val bo = ByteArrayOutputStream()
        System.setOut(PrintStream(bo))

        adapter.log("unit testing")

        bo.flush()
        var lines = String(bo.toByteArray())

        assert(lines.contains("Database adapter"))
        assert(lines.contains("Context available"))
        assert(lines.contains("unit testing"))
    }
}