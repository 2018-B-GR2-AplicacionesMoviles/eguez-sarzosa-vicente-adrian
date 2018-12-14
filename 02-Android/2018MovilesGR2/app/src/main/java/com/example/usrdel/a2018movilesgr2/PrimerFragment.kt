package com.example.usrdel.a2018movilesgr2

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_primer.*


class PrimerFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(
                R.layout.fragment_primer, // XML A USARSE
                container,
                false
        )
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (arguments != null) {

            Log.i("fragmentos", arguments!!.getString("nombre"))

            text_view_primer_fragmento
                    .text = arguments!!.getString("nombre")

        }


    }

}
