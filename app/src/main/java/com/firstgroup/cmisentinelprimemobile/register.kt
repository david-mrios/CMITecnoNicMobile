package com.firstgroup.cmisentinelprimemobile

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.firstgroup.cmisentinelprimemobile.databinding.ActivityRegisterBinding // Asegúrate de importar el binding generado
import android.util.Patterns

class register : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnRegister.setOnClickListener {
            if (validateFields()) {
                // Si todos los campos son válidos, procede al MainMenu
                val intent = Intent(this, MainMenu::class.java)
                startActivity(intent)
            }
        }

        binding.linkSignUp.setOnClickListener {
            val intent = Intent(this, login::class.java)
            startActivity(intent)
        }


    }

    private fun validateFields(): Boolean {
        var isValid = true

        if (binding.editTxtFullName.text.isNullOrEmpty()) {
            binding.editTxtFullName.error = "Nombre completo es requerido"
            isValid = false
        }

        if (binding.editTxtPhone.text.isNullOrEmpty()) {
            binding.editTxtPhone.error = "Número de teléfono es requerido"
            isValid = false
        } else if (!binding.editTxtPhone.text.toString().matches(Regex("^[0-9]{8}$"))) {
            binding.editTxtPhone.error = "Número de teléfono no válido"
            isValid = false
        }

        if (binding.editTxtEmail.text.isNullOrEmpty()) {
            binding.editTxtEmail.error = "Correo electrónico es requerido"
            isValid = false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(binding.editTxtEmail.text.toString()).matches()) {
            binding.editTxtEmail.error = "Correo electrónico no válido"
            isValid = false
        }

        if (binding.textEditPass.text.isNullOrEmpty()) {
            binding.inputPass.error = "Contraseña es requerida"
            isValid = false
        } else if (binding.textEditPass.text.toString().length < 6) {
            binding.inputPass.error = "La contraseña debe tener al menos 6 caracteres"
            isValid = false
        } else {
            binding.inputPass.error = null
        }

        return isValid
    }
}
