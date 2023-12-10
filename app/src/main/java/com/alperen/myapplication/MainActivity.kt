package com.alperen.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.alperen.myapplication.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth


// SİGN IN
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        firebaseAuth = FirebaseAuth.getInstance()



        //GİRİŞ YAP BUTONU
        binding.loginbtn.setOnClickListener {

            val email = binding.InputMail.text.toString()
            val pass = binding.InputPassword.text.toString()
            if( email.isNotEmpty()&& pass.isNotEmpty())
            {
                firebaseAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener{
                    if (it.isSuccessful)
                    {
                        val intent = Intent(applicationContext, HomePage::class.java)
                        startActivity(intent)
                    }
                    else{
                        Toast.makeText(this,it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }

                }
            }
            else
            {
                Toast.makeText(this, "Alanlar boş bırakılamaz", Toast.LENGTH_SHORT).show()
            }
        }


        // KAYIT EKRANI BUTONU
        binding.registerbtn.setOnClickListener {
            val intent = Intent(applicationContext, registerscreen::class.java)
            startActivity(intent)
        }

    }

    override fun onStart() {
        super.onStart()

        if(firebaseAuth.currentUser!=null)
        {
            val intent =Intent(this,HomePage::class.java)
            startActivity((intent))
        }
    }
}