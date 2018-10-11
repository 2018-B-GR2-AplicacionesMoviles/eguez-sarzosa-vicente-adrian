/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */

import java.util.Date

fun main(args: Array<String>){

    println("Hola mundo")

    // Int edad = 29;

    // Mutable -> Cambiarse / Reasignar

    var edad: Int = 29

    edad = 10

    // Inmutable -> No puede cambiarse / No se puede reasignar

    val edadInmutable:Int = 29


    // Duck Typing

    var curso = 101 // Inferi que es un Int

    curso = 102

    var nombre = "Adrian"

    var apellido = 'H'

    var casado = false

    var sueldo = 10.1

    var fechaNacimiento = Date()

    println(fechaNacimiento.toString())


    when(casado){
        false -> println("Feliz $nombre") // template strings
        true -> println("Triste ${nombre}") // template strings
        else -> {
            println("No me voy a ejecutar")
            println("Ni yo tampoco")
        }
    }

    var bono = if (casado) 1000.00 else 0.00

    val sueldoTotal = calcularSueldo(bono)
    println(sueldoTotal)

    val adrian = Usuario("Adrian")
    println(adrian)

}

fun calcularSueldo(bono: Double): Double{
    var sueldo = 800.00
    return sueldo + bono
}

fun saludar(): Unit{
    println("Hola mundo")
}

class Usuario{
    public var nombre:String

    constructor(vNombre: String){
        this.nombre = vNombre
        nombre = vNombre
    }

    override fun toString(): String{
        return "Hola ${this.nombre}"
    }
}






