package com.example.usrdel.a2018movilesgr2

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import com.example.usrdel.a2018movilesgr2.R.styleable.Snackbar


import kotlinx.android.synthetic.main.activity_menu2.*

class Menu2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu2)


        setSupportActionBar(toolbar)



        fab.setOnClickListener { view ->

        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.options_menu, menu)
        return true
    }

}













