package com.test.currencyconverter.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.test.currencyconverter.R

class RatesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rates)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(
                    R.id.container,
                    RatesFragment.newInstance()
                )
                .commitNow()
        }
    }
}
