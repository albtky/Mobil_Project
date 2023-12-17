package com.alperen.myapplication


import android.content.Intent
import android.net.Uri
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import com.alperen.myapplication.databinding.UserProfileBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.storage.StorageReference


class UserProfileActivity : AppCompatActivity() {
    private lateinit var binding: UserProfileBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = UserProfileBinding.inflate(layoutInflater)


        val view = binding.root
        setContentView(view)

        // Bulunan sayfada bir geri gidebilmek için sol üst köşeye konan iconun onClick'i
        binding.backBtnInProfile.setOnClickListener {
            val intent = Intent(this, HomePageActivity::class.java)
            startActivity(intent)

        }
        // Kullanıcının kişisel bilgilerini güncellediği page
        binding.settingsInProfile.setOnClickListener {
            val int = Intent(this, SettingsPageActivity::class.java)
            startActivity(int)
        }

    }
}