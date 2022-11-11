package com.example.myapplication.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Nota(
    @PrimaryKey(autoGenerate = true)
    val uid: Int,
    val titulo: String?,
    val descripcion: String?,
    val foto: String?,
    val video: String?,
    val fechaCreacion: String
) {

}