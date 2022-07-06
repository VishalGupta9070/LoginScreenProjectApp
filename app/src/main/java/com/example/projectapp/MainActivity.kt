package com.example.projectapp

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.projectapp.databinding.ActivityMainBinding
import com.example.projectapp.roomdata.Details
import com.example.projectapp.roomdata.DetailsDatabase
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    lateinit var database: DetailsDatabase
    lateinit var binding: ActivityMainBinding
    var errorMsg: String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        database = Room.databaseBuilder(applicationContext,
            DetailsDatabase::class.java,
            "detailsDB").build()
        binding.button.setOnClickListener {
            if(formValidation(binding.editTextName.text.toString(),binding.edittextEmail.text.toString(),binding.edittextPassword.text.toString())){
            GlobalScope.launch {
                database.detailsDao().insertdetails(Details(0,
                    binding.editTextName.text.toString(),
                    binding.edittextEmail.text.toString(),
                    binding.edittextPassword.text.toString()))
                val intent = Intent(this@MainActivity, DetailsActivity::class.java)
                startActivity(intent)
            }}else{
                errorMsg?.let { it1 -> Snackbar.make(it, it1,Snackbar.LENGTH_SHORT).show() }
            }


        }
    }
    fun formValidation(name:String,email:String,password:String) : Boolean{
        if(name.isEmpty()){
            errorMsg = "Name field is empty"
            return false
        }else if(email.isEmpty()){
            errorMsg = "Email filed is empty"
            return false
        }else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            errorMsg = "Entered email is invalid"
            return false
        }
        else if(password.isEmpty()){
            errorMsg = "Password filed is empty"
            return false
        }else  if(password.length<6){
            errorMsg = "Password should be more than 6 character"
            return false
        }
        return true
    }
}