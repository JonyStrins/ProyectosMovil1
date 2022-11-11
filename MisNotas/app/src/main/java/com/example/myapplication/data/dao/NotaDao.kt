package com.example.myapplication.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.myapplication.data.model.Nota
import kotlinx.coroutines.flow.Flow

@Dao
interface NotaDao {
    @Insert
    suspend fun insertar(nota: Nota)
    @Update
    fun actualizar(nota: Nota)
    @Delete
    fun eliminar(nota: Nota)
    @Query("select * from Nota")
    fun getAll():List<Nota>
    @Query("select * from Nota where uid=:id")
    fun getOneByID(id: Int): Nota

    @Query("select * from Nota order by fechaCreacion DESC")
    fun getAllOrder(): Flow<List<Nota>>

    @Query("DELETE FROM nota")
    suspend fun deleteAll()
}
