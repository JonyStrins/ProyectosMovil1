package com.example.proyectob

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class SigninActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        val titulo = intent.getStringExtra("otropar")
//        title = titulo
        this.title = titulo

        val accion = intent.getIntExtra("param1", -1)
        Toast.makeText(applicationContext, "Accion: $accion", Toast.LENGTH_LONG).show()
    }
}