package com.firstgroup.cmisentinelprimemobile

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.firstgroup.cmisentinelprimemobile.databinding.ActivityLanguageBinding
import com.firstgroup.cmisentinelprimemobile.databinding.ActivityLoginBinding
import com.firstgroup.cmisentinelprimemobile.databinding.ActivityProfileBinding
import com.firstgroup.cmisentinelprimemobile.databinding.FragmentSettingsBinding

class profile : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        binding.addImgBtn.setOnClickListener {
            val intent = Intent(this, editProfile::class.java)
            startActivity(intent)
            finish()
        }

        binding.backImgBtn.setOnClickListener {
            val intent = Intent(this, MainMenu::class.java)
            startActivity(intent)
            finish()
        }

    }
}