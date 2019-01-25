package com.example.usrdel.a2018movilesgr2

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.support.v4.content.FileProvider
import android.util.Log
import android.widget.ArrayAdapter
import com.google.firebase.ml.vision.FirebaseVision
import com.google.firebase.ml.vision.common.FirebaseVisionImage
import kotlinx.android.synthetic.main.activity_mlkit.*
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

class MLKitActivity : AppCompatActivity() {

    var pathActualFoto = ""

    var respuestasBarCode = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mlkit)

        button_tomar_foto
                .setOnClickListener {
                    tomarFoto()
                }
    }

    fun tomarFoto() {
        val archivoImagen = crearArchivo(
                "JPEG_",
                Environment.DIRECTORY_PICTURES,
                ".jpg")

        pathActualFoto = archivoImagen.absolutePath

        enviarIntentFoto(archivoImagen)

    }

    private fun crearArchivo(
            prefijo: String,
            directorio: String,
            extension: String): File {

        val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss")
                .format(Date())

        val prefijoImagen = prefijo + timeStamp + "_"

        val directorioAGuardarImagen = getExternalFilesDir(directorio)

        return File.createTempFile(
                prefijoImagen, /* prefijo */
                extension, /* fufijo */
                directorioAGuardarImagen /* directorio */
        )
    }

    private fun enviarIntentFoto(archivo: File) {

        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

        val photoURI: Uri = FileProvider.getUriForFile(
                this,
                "com.example.usrdel.a2018movilesgr2",
                archivo)

        takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)

        if (takePictureIntent.resolveActivity(packageManager) != null) {

            startActivityForResult(takePictureIntent, TOMAR_FOTO_REQUEST);

        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (requestCode) {
            TOMAR_FOTO_REQUEST -> {
                if (resultCode == Activity.RESULT_OK) {
                    mostrarFotoImageView()
                    // obtenerInfoCodigoBarras(obtenerBitmapDeArchivo(mPathActualFoto))
                }
            }

        }
    }

    fun mostrarFotoImageView() {
        image_view_codigo_barras
                .setImageBitmap(
                        obtenerBitmapDeArchivo(pathActualFoto)
                )
    }

    fun obtenerBitmapDeArchivo(path: String): Bitmap {
        val archivoImagen = File(path)
        return BitmapFactory
                .decodeFile(
                        archivoImagen.getAbsolutePath()
                )
    }


    fun obtenerInfoCodigoBarras(bitmap: Bitmap) {
        val image = FirebaseVisionImage.fromBitmap(bitmap)
        val detector = FirebaseVision.getInstance()
                .visionBarcodeDetector
        Log.i("info", "------- Entro a detectar")
        val result = detector.detectInImage(image)
                .addOnSuccessListener { barCodes ->
                    Log.i("info", "------- tamano del barcode ${barCodes.size}")
                    respuestasBarCode.add("Ejemplo")
                    for (barcode in barCodes) {
                        val bounds = barcode.getBoundingBox()
                        val corners = barcode.getCornerPoints()

                        val rawValue = barcode.getRawValue()

                        Log.i("info", "------- $bounds")
                        Log.i("info", "------- $corners")
                        Log.i("info", "------- $rawValue")

                        respuestasBarCode.add(rawValue.toString())
                    }

                    val adaptadorListView = ArrayAdapter<String>(
                            this,
                            android.R.layout.simple_list_item_1,
                            respuestasBarCode
                    )

                    list_view_codigo_barras.adapter = adaptadorListView
                }
                .addOnFailureListener {
                    Log.i("info", "------- No reconocio nada")
                }
    }


    companion object {
        val TOMAR_FOTO_REQUEST = 1
    }

}
