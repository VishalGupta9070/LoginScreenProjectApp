package com.example.projectapp.roomdata

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contact")
data class Details(
@PrimaryKey(autoGenerate = true)
    var id : Int,
val name : String,
    val email : String,
    val password : String
    )
