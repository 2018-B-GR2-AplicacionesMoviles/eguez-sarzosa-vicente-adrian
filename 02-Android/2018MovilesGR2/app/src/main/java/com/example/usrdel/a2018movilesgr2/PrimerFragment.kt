package com.example.usrdel.a2018movilesgr2

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class PrimerFragment : Fragment() {

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        Log.i("fragmentos","On Attach")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(
                R.layout.fragment_primer, // XML A USARSE
                container,
                false
        )
    }

}
