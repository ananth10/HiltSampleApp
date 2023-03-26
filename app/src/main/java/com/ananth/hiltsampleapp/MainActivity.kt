package com.ananth.hiltsampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.ananth.hiltsampleapp.database.DatabaseAdapter
import com.ananth.hiltsampleapp.database.DatabaseService
import com.ananth.hiltsampleapp.hilt.CallInterceptor
import com.ananth.hiltsampleapp.hilt.ResponseInterceptor
import com.ananth.hiltsampleapp.network.NetworkAdapter
import com.ananth.hiltsampleapp.network.NetworkService
import com.ananth.hiltsampleapp.stats.StatsViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    //field injection
    @Inject
    lateinit var databaseAdapter: DatabaseAdapter
//    @Inject lateinit var networkAdapter: NetworkAdapter

    //    @CallInterceptor
    @ResponseInterceptor
    @Inject
    lateinit var networkService1: NetworkService

    @ResponseInterceptor
    @Inject
    lateinit var networkService2: NetworkService

    @ResponseInterceptor
    @Inject
    lateinit var networkService3: NetworkService


    private val statsViewModel: StatsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println("Database adapter Instance:$databaseAdapter")
        databaseAdapter.log("hello")

//        networkAdapter.log("Network adapter from MainActivity:$this")
        networkService1.performNetworkCall()
        networkService2.performNetworkCall()
        networkService3.performNetworkCall()

        statsViewModel.statsLiveData.observe(this) { stats ->
            println("STATS VALUE:$stats")
        }
        statsViewModel.startStatsCollection()
    }

    @Inject //Method inject. we let hilt know provide the DatabaseService instance to this method
    fun directToDatabaseService(databaseService: DatabaseService) {
        databaseService.log("calling database service")
    }
}