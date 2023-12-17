package com.alperen.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import com.alperen.myapplication.databinding.ActivityHomePageBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.userProfileChangeRequest
import java.lang.reflect.Array.get

class HomePageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomePageBinding

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomePageBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var userList = ArrayList<UserInfo>()
        val layoutManager = LinearLayoutManager(this)
        val userInfo =
            UserInfo("alperen tokay", "21", "Mobil Yazılımcı", "alperen.tky06@gmail.com", "123456")
        val userInfo2 =
            UserInfo("Ayşe Kaya", "40", "Yapay Zeka ve Veri Bilimi", "ayse@gmail.com", "123456")
        val userInfo3 =
            UserInfo("Ahmet Yılman", "34", " Siber Güvenlik", "ahmet@gmail.com", "123456")
        val userInfo4 = UserInfo("Esra Demir", "23", "Mobil Yazılımcı", "esra@gmail.com", "123456")
        val userInfo5 =
            UserInfo("Mehmet Çelik", "24", "Blockchain Teknolojisi", "mehmet@gmail.com", "123456")
        val userInfo6 = UserInfo("Elif Öztürk", "27", "Mobil Yazılımcı", "elif@gmail.com", "123456")

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
        adapter.setOnItemClickListener(object : RecyclerAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                // Tıklandığında UserProfileActivity'ye geçiş yapacak Intent kodu
                val intent = Intent(this@HomePageActivity, UserProfileActivity::class.java)
                // Geçiş yaparken gerekli verileri veya bilgileri eklemek isterseniz burada ekleyebilirsiniz
                // intent.putExtra("KEY", value); gibi

                startActivity(intent)
            }
        })
        binding.settings.setOnClickListener {
            intent = Intent(this, UserProfileActivity::class.java)
            startActivity(intent)
        }



    }


}



