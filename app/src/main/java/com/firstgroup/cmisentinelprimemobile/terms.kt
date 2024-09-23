package com.firstgroup.cmisentinelprimemobile

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.firstgroup.cmisentinelprimemobile.databinding.ActivityProfileBinding
import com.firstgroup.cmisentinelprimemobile.databinding.ActivityTermsBinding

class Terms : AppCompatActivity() {

    private lateinit var binding: ActivityTermsBinding


    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityTermsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
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
    }
}