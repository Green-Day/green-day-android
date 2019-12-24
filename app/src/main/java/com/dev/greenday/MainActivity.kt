package com.dev.greenday

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.dev.greenday.fragment.FragmentAuthorization
import com.dev.greenday.fragment.FragmentMenu

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            val fragment = FragmentAuthorization()
            supportFragmentManager.beginTransaction()
                .add(R.id.container, fragment, "authorization")
                .commit();
        }
    }
}
