package com.example.realtimedatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Add : AppCompatActivity() {
    private lateinit var editName: EditText
    private lateinit var edit: EditText
    private lateinit var Text: EditText
    private lateinit var button: Button
    private lateinit var dbRef: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        editName = findViewById(R.id.name)
        edit = findViewById(R.id.editTextTextPersonName)
        Text = findViewById(R.id.editTextTextPassword)

        button = findViewById(R.id.button)

        dbRef = FirebaseDatabase.getInstance().getReference("Users")

        button.setOnClickListener {
            saveUsersData()
        }

    }

    private fun saveUsersData() {

        val text1 = editName.text.toString()
        val text2 = edit.text.toString()
        val text3 = Text.text.toString()

        if (editName.text.isEmpty()) {
            Toast.makeText(
                this, "Enter Fill" +
                        "", Toast.LENGTH_SHORT
            ).show()
        }
        if (edit.text.isEmpty()) {
            Toast.makeText(this, "Enter Fill", Toast.LENGTH_SHORT).show()
        }

        if (Text.text.isEmpty()) {
            Toast.makeText(this, "Enter Fill", Toast.LENGTH_SHORT).show()
        }

        val emploid = dbRef.push().key!!

        val employee = employe(emploid, text1, text2, text3)

        dbRef.child(emploid).setValue(employee)
            .addOnCompleteListener {
                Toast.makeText(this@Add, "Data Added Successfully", Toast.LENGTH_SHORT).show()
                editName.text.clear()
                Text.text.clear()
                edit.text.clear()
            }.addOnFailureListener {
                Toast.makeText(this@Add, "Error", Toast.LENGTH_SHORT).show()
            }


    }
}