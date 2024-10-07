package com.firstgroup.cmisentinelprimemobile

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.firstgroup.cmisentinelprimemobile.databinding.ActivityChangePasswordBinding
import com.firstgroup.cmisentinelprimemobile.databinding.ActivityProfileBinding

class changePassword : AppCompatActivity() {

    private lateinit var binding: ActivityChangePasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityChangePasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.backButton.setOnClickListener {
            val intent = Intent(this, MainMenu::class.java).apply {
                putExtra("fragmentToLoad", "SettingsFragment")
            }
            startActivity(intent)
            finish()
        }
        binding.button.setOnClickListener {
            val intent = Intent(this, MainMenu::class.java).apply {
                putExtra("fragmentToLoad", "SettingsFragment")
            }
            startActivity(intent)
            finish()
        }
    }
}