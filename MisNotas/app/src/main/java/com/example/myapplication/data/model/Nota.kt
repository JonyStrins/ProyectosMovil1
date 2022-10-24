package com.example.myapplication.data.model

import androidx.room.Entity
import java.util.*

@Entity
data class Nota(
    val uid: Int,
    val titulo: String,
    val descripcion: String,
    val clasificacion: Int,
    val fechaTarea: String?
) {

}