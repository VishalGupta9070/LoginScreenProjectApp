package com.example.projectapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.projectapp.recyclerview.AdapterList
import com.example.projectapp.roomdata.DetailsDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DetailsActivity : AppCompatActivity() {
    lateinit var database: DetailsDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        database = Room.databaseBuilder(applicationContext,
            DetailsDatabase::class.java,
            "detailsDB").build()
        val adapter = AdapterList(this,ArrayList())
    val recyclerView = findViewById<RecyclerView> (R.id.recyclerView1)
        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter = adapter
        GlobalScope.launch {
            adapter.updateList(database.detailsDao().getDetails())
        }

    }
    }
