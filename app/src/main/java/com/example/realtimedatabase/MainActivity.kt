package com.example.realtimedatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    private lateinit var addbutton: Button
    private lateinit var fetchbutton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addbutton = findViewById(R.id.add)
        fetchbutton = findViewById(R.id.fetch)




        addbutton.setOnClickListener {
            val intent = Intent(this@MainActivity,Add::class.java)
            startActivity(intent)
        }

    }
}