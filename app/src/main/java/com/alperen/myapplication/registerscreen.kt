package com.alperen.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alperen.myapplication.databinding.ActivityMainBinding
import com.alperen.myapplication.databinding.ActivityRegisterscreenBinding

class registerscreen : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterscreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterscreenBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        Toast.makeText(this, "MERHABA", Toast.LENGTH_SHORT).show()

        binding.next.setOnClickListener {

            val intent = Intent(applicationContext,HomePage::class.java)
            startActivity(intent)
        }


    }
}