package com.firstgroup.cmisentinelprimemobile

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.firstgroup.cmisentinelprimemobile.databinding.ActivityLanguageBinding
import com.firstgroup.cmisentinelprimemobile.databinding.ActivityLoginBinding

class language : AppCompatActivity() {

    // Declarar los RadioButtons
    private lateinit var radioButtonEnglish: RadioButton
    private lateinit var radioButtonFrench: RadioButton
    private lateinit var radioButtonAustralia: RadioButton
    private lateinit var radioButtonSpanish: RadioButton
    private lateinit var radioButtonVietnam: RadioButton
    private lateinit var binding: ActivityLanguageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLanguageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        binding.backButton.setOnClickListener {
            val intent = Intent(this, MainMenu::class.java)
            startActivity(intent)
            finish()
        }

        radioButtonEnglish = findViewById(R.id.radioBtnEnglish)
        radioButtonFrench = findViewById(R.id.radioBtnFrance)
        radioButtonAustralia = findViewById(R.id.radioBtnAustralia)
        radioButtonSpanish = findViewById(R.id.radioBtnSpanish)
        radioButtonVietnam = findViewById(R.id.radioBtnVietnam)

        radioButtonSpanish.isChecked = true

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
