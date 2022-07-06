package com.example.projectapp.roomdata

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Details::class], version = 1)
abstract class DetailsDatabase : RoomDatabase() {

    abstract  fun detailsDao() : DetailsDao

}