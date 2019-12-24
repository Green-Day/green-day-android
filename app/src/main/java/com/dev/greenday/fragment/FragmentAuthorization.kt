package com.dev.greenday.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.dev.greenday.R

class FragmentAuthorization: Fragment() {

    private lateinit var submitBt: Button;
    private lateinit var registrationBt: Button;

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v =
            inflater.inflate(R.layout.fragment_input, container, false)

        submitBt = v.findViewById(R.id.bt_sign_in)
        registrationBt = v.findViewById(R.id.bt_sign_up)


        submitBt.setOnClickListener {
            val fragment = FragmentMenu()
            fragmentManager!!.beginTransaction()
                .replace(R.id.container, fragment, "main_menu")
                .commit()
        }

        registrationBt.setOnClickListener {
            val fragment = FragmentRegistration()
            fragmentManager!!.beginTransaction()
                .addToBackStack("authorization")
                .replace(R.id.container, fragment, "registration")
                .commit()
        }

        return v
    }
}