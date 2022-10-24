package com.example.dialogos

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.dialogos.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.layout_dialogo1.*

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Quien eres?")
        //builder.setMessage("Algo Salio Mal, Deseas Reintentar?")
        val inflater = layoutInflater
        //Aqui se establece el layout a un dialog
        builder.setView(inflater.inflate(R.layout.layout_dialogo1, null))
        builder.setPositiveButton("Iniciar Sesion"){

            dialog, which ->

            val name = (dialog as AlertDialog).txtName.text
                Toast.makeText(this,
                "Hola ${name}",
                Toast.LENGTH_LONG).show()
        }
        builder.setNegativeButton("Cancelar", null)
        //builder.setNeutralButton("Recordar mas tarde", null)
        builder.show()

        binding.btn1.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Hola")
            builder.setMessage("Estas seguro que deseas salir?")
            builder.setPositiveButton(android.R.string.ok){
                dialog, which ->
                Toast.makeText(this, "Hasta Pronto", Toast.LENGTH_LONG).show()
            }
            builder.setNegativeButton(android.R.string.cancel){
                dialog, which ->
                Toast.makeText(this, "Te has quedado", Toast.LENGTH_LONG).show()
            }
            builder.show()
        }

        binding.btn2.setOnClickListener {
            ProgressDialog.show(
                this,
                "Progress Bar",
                "Esperanding",
                true,
                true
            )
        }

        binding.btn3.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Atencion!")
            builder.setMessage("Ejemplo de Dialogo Simple")
            builder.setCancelable(false)
            builder.setNeutralButton("Aceptar"){
                dialog, which ->
                dialog.cancel()
            }
            builder.show()
        }

        binding.btn4.setOnClickListener {
            val lista = arrayOf("Uno", "Dos", "Tres", "Cuatro", "Cinco")
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Lista de Datos")
            builder.setItems(lista) { id, posicion ->
                Toast.makeText(this, lista[posicion], Toast.LENGTH_LONG).show()
            }
            builder.show()
        }

        binding.btn5.setOnClickListener {
            showDatePickerDialog()
        }

        binding.btn6.setOnClickListener {
            showTimePickerDialog()
        }

        binding.btn7.setOnClickListener {
            val lista = arrayOf("Uno", "Dos", "Tres", "Cuatro", "Cinco")
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Lista de Datos")
            builder.setSingleChoiceItems(lista, -1) { _, posicion ->
                Toast.makeText(this, lista[posicion], Toast.LENGTH_LONG).show()
            }
            builder.setPositiveButton(android.R.string.ok){
                dialog, _ ->

                val posicionRadio = (dialog as AlertDialog).listView.checkedItemPosition

                Toast.makeText(this, "Has escogido: ${lista[posicionRadio]}", Toast.LENGTH_LONG).show()
            }
            builder.show()
        }

        binding.btn8.setOnClickListener {
            val lista = arrayOf("Uno", "Dos", "Tres", "Cuatro", "Cinco")
            val escogidos = arrayListOf<Int>()
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Lista de Datos")
            builder.setMultiChoiceItems(lista, null) { _, posicion, pulsado ->
                if(pulsado){
                    escogidos.add(posicion)
                    Toast.makeText(this, "Activado ${posicion}", Toast.LENGTH_LONG).show()
                }
                else{
                    escogidos.remove(posicion)
                    Toast.makeText(this, "Desactivado ${posicion}", Toast.LENGTH_LONG).show()
                }
            }
            builder.setPositiveButton(android.R.string.ok){
                    dialog, _ ->
                var respuesta = ""
                if (escogidos.size>0){
                    for(item in escogidos){
                        respuesta += lista[item] + " "
                    }
                }else
                    respuesta = "No se ha escogido ningun elemento"

                val posicionRadio = (dialog as AlertDialog).listView.checkedItemPosition

                Toast.makeText(this, respuesta, Toast.LENGTH_LONG).show()
            }
            builder.show()
        }
    }

    private fun showTimePickerDialog() {
        val timePicker = TimePickerFragment {onTimeSelected(it)}
        timePicker.show(supportFragmentManager, "time")
    }

    fun onTimeSelected(time:String){
        Toast.makeText(this, time,Toast.LENGTH_LONG).show()
    }

    private fun showDatePickerDialog() {
        val datePicker = DatePickerFragment{day, month, year -> onDaySelected(day, month, year) }
        datePicker.show(supportFragmentManager, "datePicker")
    }

    fun onDaySelected(day:Int, month:Int, year:Int){
        Toast.makeText(this, "${day}/${month}/${year}",Toast.LENGTH_LONG).show()
    }
}