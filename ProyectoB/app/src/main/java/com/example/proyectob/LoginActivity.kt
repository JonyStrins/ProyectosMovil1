package com.example.proyectob

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity(){

    lateinit var btnSignin : Button
    lateinit var actResultLauncher : ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_login)

        actResultLauncher = registerForActivityResult(ActivityResultContracts.StarActivityForResult(),
            ActivityResultCallback {

            })

        btnSignin = findViewById(R.id.btnSignin)
        btnSignin.setOnClickListener {
            // Para abrir otra actividad se debe realizar
            // 1) declarar una variable de tipo intent e inicializar con la actividad que se abrira
//            val int_act_signin = Intent(applicationContext, SigninActivity::class.java)
//            int_act_signin.putExtra("param1", 0)
//            int_act_signin.putExtra("otropar", "Register")
//            //2) Mandar llamar la actividad con el metodo:
//            startActivity(int_act_signin)

            val int_act_signin =
                Intent(applicationContext, SigninActivity::class.java).apply{
                    this.putExtra("param1", 0)
                    this.putExtra("otropar", "Register")
                }
            startActivity(int_act_signin)
        }
    }



}