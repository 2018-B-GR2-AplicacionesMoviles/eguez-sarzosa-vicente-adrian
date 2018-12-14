package com.example.usrdel.a2018movilesgr2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class FragmentosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragmentos)

        // Manager
        // val fragmentManager = supportFragmentManager

        // Transacciones
        // val fragmentTransaction = fragmentManager.beginTransaction()

        // Crear instancia de fragmento
        // val primerFragmento = PrimerFragment()

        // Anadir fragmento
        // fragmentTransaction.add(R.id.fragment_primer, primerFragmento)

        // Commit
        // fragmentTransaction.commit()


        /*
        boton_tab1.setOnClickListener { view ->
            reemplazarFragmentoActual(FragmentoUno())
        }
        boton_tab2.setOnClickListener { view ->
            reemplazarFragmentoActual(FragmentoDos())
        }
        boton_tab3.setOnClickListener { view ->
            reemplazarFragmentoActual(FragmentoTres())
        }
        boton_destruir_fragmento.setOnClickListener { view ->
            destruirFragmentoActual()
        }
        */
    }
    /*
    fun destruirFragmentoActual() {
        val fragmentManager = supportFragmentManager
        // Transacciones
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.remove(fragmentoActual)
        fragmentTransaction.commit()
    }


    fun reemplazarFragmentoActual(fragmento: android.support.v4.app.Fragment) {
        fragmentoActual = fragmento
        // Manager
        val fragmentManager = supportFragmentManager
        // Transacciones
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.rl_fragmento, fragmento)
        fragmentTransaction.commit()
    }
    */
}
