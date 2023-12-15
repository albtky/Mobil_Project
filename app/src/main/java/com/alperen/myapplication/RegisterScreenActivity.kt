package com.alperen.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.alperen.myapplication.databinding.ActivityRegisterscreenBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


// SİGN UP
class RegisterScreenActivity : AppCompatActivity() {
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
            val nameSurname = binding.regName.text.toString()
            val age = binding.regAge.text.toString()
            val job = binding.regJob.text.toString()
            if (nameSurname.isNotEmpty() && age.isNotEmpty() && job.isNotEmpty() && email.isNotEmpty() && pass.isNotEmpty()) {

                var db = FirebaseDatabase.getInstance().getReference()
                db.child("Users")
                var id = db.push()
                id.child("id").setValue(id.key.toString())
                id.setValue(UserInfo(nameSurname, age, job, email, pass))
                binding.regAge.setText("")
                binding.regName.setText("")
                binding.regJob.setText("")
                binding.regemail.setText("")
                binding.regpass.setText("")

                firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
                    if (it.isSuccessful) {

                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()

                    }
                }
            } else {
                Toast.makeText(this, "Alan boş bırakılamaz", Toast.LENGTH_SHORT).show()
            }
        }

        binding.textsignN.setOnClickListener {
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }


    }
}