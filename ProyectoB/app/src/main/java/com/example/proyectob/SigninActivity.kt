package com.example.proyectob

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*

class SigninActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var arrSex: Array<String>
    lateinit var txtN : EditText
    lateinit var txtE : EditText
    lateinit var btnSave : Button
    lateinit var spnSex : Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        spnSex = findViewById(R.id.spnSexo)

        //1 Coleccion

        arrSex = resources.getStringArray(R.array.arrSexo)

        //2 Adaptador

        val adaptador = ArrayAdapter(applicationContext,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                arrSex
            )

        spnSex.adapter = adaptador

        //spnSex.onItemSelectedListener = this
        spnSex.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                //TODO("Not yet implemented")
                val itemSele = arrSex[p2]
                Toast.makeText(
                    applicationContext,
                    "Elemento seleccionado: $itemSele",
                    Toast.LENGTH_LONG
                ).show()
                Log.d("SPINNER", "Elemento Seleccionado: $itemSele")
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                //TODO("Not yet implemented")
            }

        }

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

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        //TODO("Not yet implemented")
        val itemSele = arrSex[p2]
        Toast.makeText(
            applicationContext,
            "Elemento seleccionado: $itemSele",
            Toast.LENGTH_LONG
        ).show()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        //TODO("Not yet implemented")
    }

}