package com.alperen.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.alperen.myapplication.databinding.ActivityHomePageBinding

class HomePage : AppCompatActivity() {
    private lateinit var binding:ActivityHomePageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityHomePageBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var UserList =ArrayList<View>()
        UserList.add(binding.recyclerview)
        val layoutManager= LinearLayoutManager(this)
        binding.recyclerview.layoutManager = layoutManager
        val adapter  = recycle_adapter(UserList)
        binding.recyclerview.adapter=adapter


    }
}