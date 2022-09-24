package com.example.proyectob

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text

class LoginActivity : AppCompatActivity(){

    lateinit var btnSignin : Button
    lateinit var actResultLauncher : ActivityResultLauncher<Intent>
    lateinit var txtUser : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_login)


        actResultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult(), // Usar cuando la app va a resivir algo
            ActivityResultCallback {
                if (it.resultCode == RESULT_OK){
                    val intpar = it.data
                    val email = intpar?.getStringExtra("email")

                    Toast.makeText(applicationContext,
                        "email: $email",
                        Toast.LENGTH_LONG
                    ).show()

                    txtUser.setText(email)

                }
            }
        )

        txtUser = findViewById(R.id.txtUser)
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
            // startActivity(int_act_signin)
           // actResultLauncher.launch()
        }

        Log.i("CICLOVida", "Paso por onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.i("CICLOVida", "Paso por onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("CICLOVida", "Paso por onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("CICLOVida", "Paso por onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("CICLOVida", "Paso por onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("CICLOVida", "Paso por onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("CICLOVida", "Paso por onDestroy")
    }

}