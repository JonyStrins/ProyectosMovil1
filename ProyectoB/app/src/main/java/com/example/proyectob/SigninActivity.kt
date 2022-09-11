package com.example.proyectob

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SigninActivity : AppCompatActivity() {

    lateinit var txtN : EditText
    lateinit var txtE : EditText
    lateinit var btnSave : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        val titulo = intent.getStringExtra("otropar")
//        title = titulo
        this.title = titulo

        val accion = intent.getIntExtra("param1", -1)
        Toast.makeText(applicationContext, "Accion: $accion", Toast.LENGTH_LONG).show()

        txtN = findViewById(R.id.txtName)
        txtE = findViewById(R.id.txtEmail)
        btnSave = findViewById(R.id.btnSignin)

        btnSave.setOnClickListener{
            val intentRes = Intent()
            intentRes.putExtra("email", txtE.text.toString())
            setResult(RESULT_OK, intentRes)
            finish()
        }
    }
}