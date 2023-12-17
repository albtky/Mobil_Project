package com.alperen.myapplication

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alperen.myapplication.databinding.CardesignBinding
import com.alperen.myapplication.databinding.ItemAddBinding
import com.alperen.myapplication.databinding.ItemEmailBinding
import com.alperen.myapplication.databinding.ItemInfoBinding

import com.alperen.myapplication.databinding.UserProfileBinding


class UserProfileActivity : AppCompatActivity() {
    private lateinit var binding: UserProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = UserProfileBinding.inflate(layoutInflater)


        val view = binding.root
        setContentView(view)

        binding.backBtnInProfile.setOnClickListener {
            val intent = Intent(this, HomePageActivity::class.java)
            startActivity(intent)

        }
        binding.settingsInProfile.setOnClickListener{
            val int = Intent(this, SettingsPageActivity::class.java)
            startActivity(int)
        }
    }
}