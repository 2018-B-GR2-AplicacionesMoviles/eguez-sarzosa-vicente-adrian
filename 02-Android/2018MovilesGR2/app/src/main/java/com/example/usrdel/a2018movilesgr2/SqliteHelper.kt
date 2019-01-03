package com.example.usrdel.a2018movilesgr2

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log


class SqliteHelper(context: Context) :
        SQLiteOpenHelper(context,
                "moviles", // Nombre de la base de datos
                null,
                1) {

    override fun onCreate(baseDeDatos: SQLiteDatabase?) {

        val crearTablaUsuario = "CREATE TABLE " +
                "usuario " +
                "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nombre VARCHAR(50)," +
                "descripcion VARCHAR(50)," +
                ")"
        Log.i("bdd", "Creando la tabla de usuario \n$crearTablaUsuario")
        baseDeDatos?.execSQL(crearTablaUsuario)
    }

    override fun onUpgrade(baseDeDatos: SQLiteDatabase?,
                           antiguaVersion: Int,
                           nuevaVersion: Int) {

    }

    fun existeUsuarioFormulario(): Boolean {

        val statement = "select * from usuario where id=1;"

        val dbReadable = readableDatabase

        val resultado = dbReadable.rawQuery(statement,
                null)

        var existeUsuario = 0

        if (resultado.moveToFirst()) {
            do {
                existeUsuario++
            } while (resultado.moveToNext())
        }
        resultado.close()
        dbReadable.close()

        return if (existeUsuario == 0) false else true
    }

    fun crearUsuarioFormulario(nombre: String,
                               descripcion: String): Boolean {
        // Base de datos de escritura
        val dbWriteable = writableDatabase
        val cv = ContentValues()

        // Valores de los campos
        cv.put("nombre", nombre)
        cv.put("descripcion", descripcion)

        val resultado: Long = dbWriteable
                .insert(
                        "usuario", // Nombre de la tabla
                        null,
                        cv)

        dbWriteable.close()

        return if (resultado.toInt() == -1) false else true

    }

    fun actualizarUsuarioFormulario(nombre: String,
                               descripcion: String): Boolean {
        // Base de datos de escritura
        val dbWriteable = writableDatabase
        val cv = ContentValues()

        // Valores de los campos
        cv.put("nombre", nombre)
        cv.put("descripcion", descripcion)

        val argumentos = { "String1"}
        val resultado = dbWriteable
                .update(
                        "usuario", // Nombre de la tabla
                        cv
                        // "id = 1",
                        // ({"1"})
                )

        dbWriteable.close()

        return if (resultado.toInt() == -1) false else true

    }


    /*
    override fun onCreate(db: SQLiteDatabase?) {

        val createTableSQL = "CREATE TABLE ${BaseDeDatos.BDD_TABLA_USUARIO_NOMBRE} (${BaseDeDatos.BDD_TABLA_USUARIO_CAMPO_ID} INTEGER PRIMARY KEY AUTOINCREMENT, ${BaseDeDatos.BDD_TABLA_USUARIO_CAMPO_NOMBRE} VARCHAR(50))"

        db?.execSQL(createTableSQL)
    }


    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun insertarUsuario(nombre: String) {
        val dbWriteable = writableDatabase
        val cv = ContentValues()

        cv.put(BaseDeDatos.BDD_TABLA_USUARIO_CAMPO_NOMBRE, nombre)

        val resultado = dbWriteable.insert(BaseDeDatos.BDD_TABLA_USUARIO_NOMBRE, null, cv)

        Log.i("database", "Si es -1 hubo error, sino exito: Respuesta: $resultado")

        dbWriteable.close()

    }

    fun leerDatos() {
        val dbReadable = readableDatabase

        val query = "SELECT * FROM ${BaseDeDatos.BDD_TABLA_USUARIO_NOMBRE}"

        val resultado = dbReadable.rawQuery(query, null)
        if (resultado.moveToFirst()) {
            do {
                val idActual = resultado.getString(0).toInt()
                val nombreActual = resultado.getString(1)
                Log.i("database", "El nombre es $nombreActual con id $idActual")
            } while (resultado.moveToNext())
        }
        resultado.close()
        dbReadable.close()
    }
*/
}






