package com.dev.greenday.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.dev.greenday.R

class FragmentRegistration: Fragment() {

    private lateinit var registrationBt: Button;

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_registration, container, false)
        registrationBt = v.findViewById(R.id.bt_sign_in)

        registrationBt.setOnClickListener {
            val fragment = FragmentAuthorization()
            fragmentManager!!.beginTransaction()
                .replace(R.id.container, fragment, "authorization")
                .commit()

        }

        return v
    }
}