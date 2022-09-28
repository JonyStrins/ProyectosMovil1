package com.example.proyectob

import android.content.Intent
import android.content.Intent.ACTION_DIAL
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class intents_action : AppCompatActivity() {

    lateinit var btn1dial : Button
    lateinit var btn2viewmap : Button
    lateinit var btn3send : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intents_action)

        btn1dial = findViewById(R.id.btnIntent1)
        btn2viewmap = findViewById(R.id.btnIntent2)
        btn3send = findViewById(R.id.btnIntentSend)

        btn1dial.setOnClickListener {
            val intent_dial = Intent(ACTION_DIAL, Uri.parse("tel: 4451074638"))
            startActivity(intent_dial)

        }
        btn2viewmap.setOnClickListener {
            var intents_view = Intent(
                    Intent.ACTION_VIEW,
                    //Uri.parse("geo:0,0?q=1600")
                    Uri.parse("https://sicenet.itsur.edu.mx")
            )
            startActivity(intents_view)
        }
        btn3send.setOnClickListener {
            var intent_send = Intent(Intent.ACTION_SEND).apply {
                this.putExtra(Intent.EXTRA_EMAIL, "alexiscalderonparamo@gmail.com")
                putExtra(Intent.EXTRA_SUBJECT, "Ora Kokies") // Este es el asunto
                putExtra(Intent.EXTRA_TEXT, "Kokeis el que lo lea") // Este es el mensaje
                type = "text/plain"
            }
            startActivity(intent_send)
        }
    }
}
