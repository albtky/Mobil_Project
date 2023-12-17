package com.alperen.myapplication

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Toast

import com.alperen.myapplication.databinding.ActivityMainBinding
import com.alperen.myapplication.databinding.CardesignBinding
import com.alperen.myapplication.databinding.ItemAddBinding
import com.alperen.myapplication.databinding.ItemEmailBinding
import com.alperen.myapplication.databinding.ItemInfoBinding
import com.alperen.myapplication.databinding.SettingsPageBinding
import com.alperen.myapplication.databinding.UserProfileBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.storage.StorageReference


// SİGN IN
class SettingsPageActivity : AppCompatActivity() {
    private lateinit var binding: SettingsPageBinding
    private lateinit var settingsBinding: SettingsPageBinding
    private lateinit var infoBinding: ItemInfoBinding
    private lateinit var addBinding: ItemAddBinding
    private lateinit var itemEmailBinding: ItemEmailBinding
    private lateinit var profileBinding: UserProfileBinding
    private lateinit var ınCardBinding: CardesignBinding
    private lateinit var firebaseRef: DatabaseReference
    private lateinit var storageRef: StorageReference
    private var uri: Uri? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        settingsBinding = SettingsPageBinding.inflate(layoutInflater)
        binding = SettingsPageBinding.inflate(layoutInflater)
        infoBinding = ItemInfoBinding.inflate(layoutInflater)
        addBinding = ItemAddBinding.inflate(layoutInflater)
        itemEmailBinding = ItemEmailBinding.inflate(layoutInflater)
        profileBinding = UserProfileBinding.inflate(layoutInflater)
        ınCardBinding = CardesignBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Kullanıcının Kişisel bilgilerini güncellediği yerden çekilen itemler
        val name = settingsBinding.nameChange.text.toString()
        val email = settingsBinding.emailChange.text.toString()
        val number = settingsBinding.changeNumber.toString()
        val ınfo = settingsBinding.hakkMdaChange.text.toString()
        val age = settingsBinding.ageChange.text.toString()
        val job = settingsBinding.jobChange.text.toString()

        //Setting kısmında kaydet butonuna basınca gerçekleşmesi beklenen aksiyonlar
        binding.saveChanges.setOnClickListener {
            profileBinding.nameInProfile.setText(name)
            itemEmailBinding.emilInItem.text = email
            ınCardBinding.age.text = age
            addBinding.hakkMdaInprofile.text = ınfo
            infoBinding.numberInProfile.text = number
            ınCardBinding.Job.text = job
            // Gönderilmesi denenen IMG dosyasının firebaser storage database'e kaydedildiği fonksiyon
            Toast.makeText(this, "GÜNCELLEMELER YAPILDI", Toast.LENGTH_SHORT).show()
            intent = Intent(this, UserProfileActivity::class.java)
            intent.putExtra("Değişen isim", name)
            intent.putExtra("Değişen isim", email)
            intent.putExtra("Değişen isim", age)
            intent.putExtra("Değişen isim", ınfo)
            intent.putExtra("Değişen isim", number)
            intent.putExtra("Değişen isim", job)

            startActivity(intent)


        }


    }

    public fun saveData() {
        val contactId = firebaseRef.push().key!!
        var contacts: ContactsContract
        uri?.let {
            storageRef.child(contactId).putFile(it)
                .addOnSuccessListener { task ->
                    task.metadata!!.reference!!.downloadUrl
                        .addOnSuccessListener { url ->
                            Toast.makeText(
                                this,
                                " Image stored successfully",
                                Toast.LENGTH_SHORT
                            ).show()
                            val imgUrl = url.toString()


                            contacts = ContactsContract()

                            firebaseRef.child(contactId).setValue(contacts)
                                .addOnCompleteListener {
                                    Toast.makeText(
                                        this,
                                        " data stored successfully",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                                .addOnFailureListener { error ->
                                    Toast.makeText(
                                        this,
                                        "error ${error.message}",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                        }

                }
        }
    }

}