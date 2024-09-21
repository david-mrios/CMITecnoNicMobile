package com.firstgroup.cmisentinelprimemobile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class StatisticsFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

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
    ): View? {
        return inflater.inflate(R.layout.fragment_statistics, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Configurar RecyclerView de estadísticas
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerVStateOrder)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val statistics = listOf(
            StatisticItem("250", "Entregado", "250", "En ruta"),
            StatisticItem("250", "Cancelado", "250", "Pendiente"),
        )

        val recycleAdapter = StatisticsAdapter(statistics)
        recyclerView.adapter = recycleAdapter


        // Datos hardcodeados para la lista
        val data = listOf(
            "Cliente A: 15 pedidos - $750000.0",
            "Cliente B: 12 pedidos - $600000.0",
            "Cliente C: 10 pedidos - $450000.0"
        )

        // Configurar el ListView
        val listView: ListView = view.findViewById(R.id.listOrder)
        val listAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, data)
        listView.adapter = listAdapter

        // Asignar el valor de ganancia al TextView
        val tvProfit: TextView = view.findViewById(R.id.tvProfit)
        val earnings = "$169.6K"
        tvProfit.text = earnings

        // Asignar el valor de ganancia al TextView
        val tvSpent: TextView = view.findViewById(R.id.tvSpent)
        val spent = "$169.6K"
        tvSpent.text = spent

        // Setear el progreso de cada barra
        val progressBarProduct1 = view.findViewById<ProgressBar>(R.id.progressBarProduct1)
        val progressBarProduct2 = view.findViewById<ProgressBar>(R.id.progressBarProduct2)
        val progressBarProduct3 = view.findViewById<ProgressBar>(R.id.progressBarProduct3)

        // Ejemplo: actualizar valores en tiempo real
        progressBarProduct1.progress = 100
        progressBarProduct2.progress = 50
        progressBarProduct3.progress = 25
    }

    companion object {
        /**
         *
         *
         * @param param1
         * @param param2
         * @return
         */
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            StatisticsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
