package com.example.projectapp.roomdata

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface DetailsDao {

@Insert
 suspend fun insertdetails(details : Details)

    @Update
  suspend fun updatedetails(details : Details)

    @Delete
    suspend fun deletedetails(details : Details)

    @Query("SELECT * FROM contact")
    suspend fun getDetails() :List<Details>
}