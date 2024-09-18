package com.firstgroup.cmisentinelprimemobile

import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class language : AppCompatActivity() {

    // Declarar los RadioButtons
    private lateinit var radioButtonEnglish: RadioButton
    private lateinit var radioButtonFrench: RadioButton
    private lateinit var radioButtonAustralia: RadioButton
    private lateinit var radioButtonSpanish: RadioButton
    private lateinit var radioButtonVietnam: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_language)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        radioButtonEnglish = findViewById(R.id.radioBtnEnglish)
        radioButtonFrench = findViewById(R.id.radioBtnFrance)
        radioButtonAustralia = findViewById(R.id.radioBtnAustralia)
        radioButtonSpanish = findViewById(R.id.radioBtnSpanish)
        radioButtonVietnam = findViewById(R.id.radioBtnVietnam)

        radioButtonEnglish.setOnClickListener(onRadioButtonClicked)
        radioButtonFrench.setOnClickListener(onRadioButtonClicked)
        radioButtonAustralia.setOnClickListener(onRadioButtonClicked)
        radioButtonSpanish.setOnClickListener(onRadioButtonClicked)
        radioButtonVietnam.setOnClickListener(onRadioButtonClicked)
    }

    private val onRadioButtonClicked = View.OnClickListener { view ->
        radioButtonEnglish.isChecked = false
        radioButtonFrench.isChecked = false
        radioButtonAustralia.isChecked = false
        radioButtonSpanish.isChecked = false
        radioButtonVietnam.isChecked = false

        (view as RadioButton).isChecked = true
    }
}
