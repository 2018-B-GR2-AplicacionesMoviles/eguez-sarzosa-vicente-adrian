package com.example.usrdel.a2018movilesgr2

import android.content.DialogInterface
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.util.Log
import android.view.View
import android.widget.Toast
import com.tapadoo.alerter.Alerter
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        button_dialogo_confirmacion
                .setOnClickListener {
                    val builder = AlertDialog.Builder(this)


                    builder
                            .setMessage("Estas seguro de pasar la materia?")
                            .setPositiveButton(
                                    "Si, de una",
                                    DialogInterface
                                            .OnClickListener { dialog, which ->
                                                Alerter.create(this@MainActivity)
                                                        .setText("El usuario selecciono que SI")
                                                        .show()
                                            }
                            )
                            .setNegativeButton(
                                    "No, vamos bielas",
                                    { dialog, which ->
                                        Alerter.create(this@MainActivity)
                                                .setText("El usuario selecciono que NO")
                                                .show()
                                    }
                            )


                    val dialogo = builder.create()
                    dialogo.show()


                    /* DialogInterface.OnClickListener { dialog, which ->
                   Log.i(
                           "a",
                           "si")
               }
               */
                }

        button_dialogo_opciones
                .setOnClickListener {
                    val builder = AlertDialog.Builder(this)


                    val listaItems = resources.getStringArray(R.array.dias_de_la_semana)

                    //(arrayOf("1", "2", "3"),

                    builder.setTitle("Dia favorito de la semana")
                            .setSingleChoiceItems(
                                    listaItems,
                                    1,
                                    null)
                            .setNeutralButton(
                                    "Cancel",
                                    null
                            )

                    val dialogo = builder.create()
                    dialogo.show()

                }


        button_alertas
                .setOnClickListener {

                    Alerter.create(this@MainActivity)
                            .setTitle("Alert Title")
                            .setText("Alert text...")
                            .setOnClickListener(View.OnClickListener {
                                Toast.makeText(
                                        this@MainActivity,
                                        "OnClick Called",
                                        Toast.LENGTH_LONG)
                                        .show();
                            })
                            .show()

                }


        boton_navegar
                .setOnClickListener {
                    /*
                    Log.i("navegacion","Hola")
                    Log.w("navegacion","Hola")
                    Log.d("navegacion","Hola")
                    Log.e("navegacion","Hola")
                    Log.v("navegacion","Hola")
                    */
                    this.irAPantallaDeBotones()
                }
        button_intent_respuesta
                .setOnClickListener {
                    this.irAPantallaDeIntentRespuesta()
                }

        button_ciclo_vida
                .setOnClickListener {
                    this.irAPantallaCicloVida()
                }

        button_intent_parcelable
                .setOnClickListener {
                    this.irActividadParcelableIntent()
                }

        button_adaptador
                .setOnClickListener {
                    this.irActividadAdaptador()
                }

        button_recycler_view
                .setOnClickListener {
                    this.irActividadRecyclerView()
                }
        button_fragmento
                .setOnClickListener {
                    this.irActividadFragmentos()
                }
        button_http
                .setOnClickListener {
                    this.irActividadHttp()
                }

        button_menu
                .setOnClickListener {
                    this.irActividadMenu()
                }

        button_ml_kit
                .setOnClickListener {
                    this.irActividadMLKit()
                }

        button_google_maps
                .setOnClickListener {
                    this.irAActividadGoogleMaps()
                }
    }

    fun irAActividadGoogleMaps() {
        val intent = Intent(
                this,
                MapaContenedorActivity::class.java
        )
        startActivity(intent)
    }

    fun irActividadMLKit() {
        val intent = Intent(
                this,
                MLKitActivity::class.java
        )
        startActivity(intent)
    }

    fun irActividadMenu() {
        val intent = Intent(
                this,
                Menu2Activity::class.java
        )
        startActivity(intent)
    }


    fun irActividadHttp() {
        val intent = Intent(
                this,
                HttpActivity::class.java
        )
        startActivity(intent)
    }

    fun irActividadFragmentos() {
        val intent = Intent(
                this,
                FragmentosActivity::class.java
        )
        startActivity(intent)
    }

    fun irActividadRecyclerView() {
        val intent = Intent(
                this,
                ReciclerViewActivity::class.java
        )
        startActivity(intent)
    }

    fun irActividadAdaptador() {
        val intentAdaptador = Intent(
                this,
                AdaptadorActivity::class.java
        )
        startActivity(intentAdaptador)
    }

    fun irActividadParcelableIntent() {
        val intentActividadIntent = Intent(
                this,
                ParcelableActivity::class.java
        )

        val adrian = Usuario(
                "Adrian",
                29,
                Date(1989, 6, 10),
                12.00)

        val cachetes = Mascota("Cachetes", adrian)

        intentActividadIntent.putExtra("usuario", adrian)
        intentActividadIntent.putExtra("mascota", cachetes)

        startActivity(intentActividadIntent)


    }

    fun irAPantallaCicloVida() {
        val intentCicloVida = Intent(
                this,
                CicloVidaActivity::class.java
        )
        this.startActivity(intentCicloVida)
    }

    fun irAPantallaDeBotones() {
        // INTENT
        val intentIrABotones = Intent(this, ButtonActivity::class.java)
        intentIrABotones.putExtra("nombre", "Adrian")
        intentIrABotones.putExtra("apellido", "Eguez")
        this.startActivity(intentIrABotones)
    }

    fun irAPantallaDeIntentRespuesta() {
        // INTENT
        val intentRespuesta = Intent(this, IntentRespuestaActivity::class.java)
        this.startActivity(intentRespuesta)
    }

}
