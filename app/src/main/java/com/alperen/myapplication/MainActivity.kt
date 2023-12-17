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



        //Oturum açmak için kullanılan butonun onClick'i
        binding.loginbtn.setOnClickListener {

            val email = binding.InputMail.text.toString()
            val pass = binding.InputPassword.text.toString()

            // Girilen değerler boş değilse eğer ve girilen bilgiler doğru ise gereken aksiyonların gerçekleşmesini sağlayan if else bloğu
            if( email.isNotEmpty()&& pass.isNotEmpty())
            {
                firebaseAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener{
                    if (it.isSuccessful)
                    {
                        val intent = Intent(applicationContext, HomePageActivity::class.java)
                        startActivity(intent)
                    }
                    else{
                        Toast.makeText(this,   "Kullanıcı bulunamadı", Toast.LENGTH_SHORT).show()
                    }

                }
            }
            else
            {
                Toast.makeText(this, "Alanlar boş bırakılamaz", Toast.LENGTH_SHORT).show()
            }
        }


        // Kayıt olma butonu onClick'i
        binding.registerbtn.setOnClickListener {
            val intent = Intent(applicationContext, RegisterScreenActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onStart() {
        super.onStart()

        if(firebaseAuth.currentUser!=null)
        {
            val intent =Intent(this,HomePageActivity::class.java)
            startActivity((intent))
        }
    }
}