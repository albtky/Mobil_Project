package com.alperen.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.alperen.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.registerbtn.setOnClickListener{
            val intent= Intent(applicationContext, registerscreen::class.java)
            startActivity(intent)
        }

        binding.loginbtn.setOnClickListener {
            val intent = Intent(applicationContext,HomePage::class.java)
            startActivity(intent)
        }




    }
}