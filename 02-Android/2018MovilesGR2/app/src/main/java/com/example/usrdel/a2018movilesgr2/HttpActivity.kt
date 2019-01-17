package com.example.usrdel.a2018movilesgr2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result

class HttpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_http)

        val url = "http://172.31.105.224:1337/Estudianteasdfaasdfasd"


        url
                .httpGet()
                .responseString { request, response, result ->

                    when (result) {
                        is Result.Failure -> {
                            val exepcion = result.getException()
                            Log.i("http", "Error: ${exepcion}")

                        }
                        is Result.Success -> {
                            val data = result.get()
                            Log.i("http", "Datos: ${data}")
                        }
                    }
                }


    }
}
