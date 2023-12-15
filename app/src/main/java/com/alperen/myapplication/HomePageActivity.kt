package com.alperen.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.alperen.myapplication.databinding.ActivityHomePageBinding
import com.google.firebase.auth.FirebaseAuth

class HomePageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomePageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomePageBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var userList = ArrayList<UserInfo>()
        val layoutManager = LinearLayoutManager(this)
        val userInfo = UserInfo("alperen tokay", "21", "Mobil Yazılımcı","alperen.tky06@gmail.com","123456")
        val userInfo2 = UserInfo("alperen tokay", "21", "Mobil Yazılımcı","alperen.tky06@gmail.com","123456")
        val userInfo3 = UserInfo("alperen tokay", "21", "Mobil Yazılımcı","alperen.tky06@gmail.com","123456")
        val userInfo4 = UserInfo("alperen tokay", "21", "Mobil Yazılımcı","alperen.tky06@gmail.com","123456")
        val userInfo5 = UserInfo("alperen tokay", "21", "Mobil Yazılımcı","alperen.tky06@gmail.com","123456")
        val userInfo6 = UserInfo("alperen tokay", "21", "Mobil Yazılımcı","alperen.tky06@gmail.com","123456")

        userList.add(userInfo)
        userList.add(userInfo2)
        userList.add(userInfo3)
        userList.add(userInfo4)
        userList.add(userInfo5)
        userList.add(userInfo6)
        binding.recyclerview.layoutManager = layoutManager
        val adapter = RecyclerAdapter(userList)
        binding.recyclerview.adapter = adapter

        binding.exitbtn.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }


    }
}