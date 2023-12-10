package com.alperen.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alperen.myapplication.databinding.ActivityMainBinding
import com.alperen.myapplication.databinding.ActivityRegisterscreenBinding
import com.google.firebase.auth.FirebaseAuth


// SİGN UP
class registerscreen : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterscreenBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterscreenBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        firebaseAuth = FirebaseAuth.getInstance()
        binding.next.setOnClickListener {

            val email = binding.regemail.text.toString()
            val pass = binding.regpass.text.toString()
            if (email.isNotEmpty() && pass.isNotEmpty())
            {
                 firebaseAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener{
                     if(it.isSuccessful)
                     {
                         val intent= Intent(this, MainActivity::class.java)
                         startActivity(intent)
                     }
                     else
                     {
                         Toast.makeText(this,it.exception.toString(), Toast.LENGTH_SHORT).show()

                     }
                 }
            }
            else{
                Toast.makeText(this, "Alan boş bırakılamaz", Toast.LENGTH_SHORT).show()
            }
        }
            binding.textsignN.setOnClickListener{
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
            }


    }
}