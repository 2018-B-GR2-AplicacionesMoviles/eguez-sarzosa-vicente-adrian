package com.example.usrdel.a2018movilesgr2

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import com.example.usrdel.a2018movilesgr2.R.styleable.Snackbar


import kotlinx.android.synthetic.main.activity_menu2.*

class Menu2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu2)
        setSupportActionBar(toolbar)
        llenarListView()
        fab.setOnClickListener { view ->

        }
    }

    fun llenarListView() {
        val numeros = arrayListOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "10")

        val adapter = ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1, numeros
        )

        list_view_context_menu.adapter = adapter

        // Registrar para que sirvan los menus contextuales

        registerForContextMenu(list_view_context_menu)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.options_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        when (item.getItemId()) {
            R.id.abrir -> {
                Log.i("menu", "Abrir")
                return true
            }
            R.id.nuevo -> {
                Log.i("menu", "Nuevo")
                return true
            }
            R.id.editar -> {
                Log.i("menu", "Editar")
                return true
            }
            R.id.eliminar -> {
                Log.i("menu", "Eliminar")
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateContextMenu(
            menu: ContextMenu,
            v: View,
            menuInfo: ContextMenu.ContextMenuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo)

        val inflater = menuInflater
        inflater.inflate(R.menu.options_menu, menu)
    }


}













