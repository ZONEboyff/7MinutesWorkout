package com.example.a7minutesworkout

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a7minutesworkout.databinding.ActivityHistoryBinding
import kotlinx.coroutines.launch

class HistoryActivity : AppCompatActivity() {
    private var binding: ActivityHistoryBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding!!.root)
        setSupportActionBar(binding?.toolbarHistoryActivity)
        if (supportActionBar != null) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.title = "HISTORY"
        }
        binding?.toolbarHistoryActivity?.setNavigationOnClickListener {
            onBackPressed()
        }
        val historyDao = (application as WorkOutApp).db.historyDao()
        getAllCompletedDates(historyDao)
    }
    private fun getAllCompletedDates(historyDao: HistoryDao){
        lifecycleScope.launch {
            historyDao.fetchAllDates().collect{
               if(it.isNotEmpty()){
                   binding?.tvHistory?.visibility = View.VISIBLE
                   binding?.rvHistory?.visibility = View.VISIBLE
                   binding?.tvNoDataAvailable?.visibility = View.INVISIBLE
                   binding?.rvHistory?.layoutManager = LinearLayoutManager(this@HistoryActivity)
                   val dates = ArrayList<String>()
                     for(i in it){
                          dates.add(i.date)
                          Log.e("Date: ",""+i.date)
                     }
                   val adapter = HistoryAdapter(dates)
                     binding?.rvHistory?.adapter = adapter
               }else{
                   binding?.tvHistory?.visibility = View.INVISIBLE
                   binding?.rvHistory?.visibility = View.INVISIBLE
                   binding?.tvNoDataAvailable?.visibility = View.VISIBLE
               }
            }
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}