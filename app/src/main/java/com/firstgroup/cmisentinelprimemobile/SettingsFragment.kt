package com.firstgroup.cmisentinelprimemobile

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.firstgroup.cmisentinelprimemobile.databinding.FragmentSettingsBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SettingsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SettingsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inicializar el binding para inflar el layout del fragmento
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)

        // Crear un OnClickListener común que navega a la actividad 'language::class.java'
        val navigateToLanguageClickListener = View.OnClickListener {
            // Crear el intent que lanzará la actividad de lenguaje
            val intent = Intent(requireContext(), language::class.java)
            // Iniciar la actividad con el intent creado
            startActivity(intent)
        }
        // Usar el método 'apply' para asignar el mismo OnClickListener a varios elementos
        binding.apply {
            // Crear una lista de las vistas que deben compartir el comportamiento de navegación
            listOf(
                linearLayoutLenguaje, // LinearLayout que envuelve el selector de lenguaje
                textLanguaje,         // Texto para cambiar el lenguaje
                btnLangueje,          // Botón para cambiar el lenguaje
                textLanguaje2
            ).forEach {
                // Asignar el OnClickListener común a cada una de las vistas de la lista
                it.setOnClickListener(navigateToLanguageClickListener)
            }
        }//Fin de Lenguaje


        // Crear navegacion de Perfil
        val navigateToProfileClickListener = View.OnClickListener {
            // Crear el intent que lanzará la actividad de perfil
            val intent = Intent(requireContext(), profile::class.java)
            // Iniciar la actividad con el intent creado
            startActivity(intent)
        }
        // Usar el método 'apply' para asignar el mismo OnClickListener a varios elementos
        binding.apply {
            // Crear una lista de las vistas que deben compartir el comportamiento de navegación
            listOf(
                linearLayoutProfile,
                textProfile,
                btnProfile
            ).forEach {
                it.setOnClickListener(navigateToProfileClickListener)
            }
        }//Fin de Perfil


        // Crear navegacion de Cambio de Contraseña
        val navigateTochangePasswordClickListener = View.OnClickListener {
            // Crear el intent que lanzará la actividad de Cambio de contraseña
            val intent = Intent(requireContext(), changePassword::class.java)
            // Iniciar la actividad con el intent creado
            startActivity(intent)
        }
        // Usar el método 'apply' para asignar el mismo OnClickListener a varios elementos
        binding.apply {
            // Crear una lista de las vistas que deben compartir el comportamiento de navegación
            listOf(
                linearLayoutPassword,
                textPassword,
                btnPassword
            ).forEach {
                it.setOnClickListener(navigateTochangePasswordClickListener)
            }
        }//Fin de Contraseña

        binding.linearLayoutTerms.setOnClickListener {
            val intent = Intent(requireContext(), Terms::class.java)
            startActivity(intent)
        }

        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SettingsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SettingsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}