package com.firstgroup.cmisentinelprimemobile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class StatisticItem(
    val countOne: String?,
    val stateOne: String?,
    val countTwo: String?,
    val stateTwo: String?
)
class StatisticsAdapter(private val statisticsList: List<StatisticItem>) :
    RecyclerView.Adapter<StatisticsAdapter.StatisticsViewHolder>() {

    // Map of states to icons
    private val iconMap = mapOf(
        "Entregado" to R.drawable.ic_delivered,
        "En ruta" to R.drawable.ic_in_route,
        "Cancelado" to R.drawable.ic_cancelled,
        "Pendiente" to R.drawable.ic_pending
        // Add more icons and states as needed
    )

    class StatisticsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val countOneTextView: TextView = view.findViewById(R.id.tvCount1)
        val stateOneTextView: TextView = view.findViewById(R.id.tvStateName1)
        val countTwoTextView: TextView = view.findViewById(R.id.tvCount2)
        val stateTwoTextView: TextView = view.findViewById(R.id.tvStateName2)
        val stateIconOne: ImageView = view.findViewById(R.id.stateIconOne)
        val stateIconTwo: ImageView = view.findViewById(R.id.stateIconTwo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatisticsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_statistics, parent, false)
        return StatisticsViewHolder(view)
    }

    override fun onBindViewHolder(holder: StatisticsViewHolder, position: Int) {
        val item = statisticsList[position]

        holder.countOneTextView.text = item.countOne
        holder.stateOneTextView.text = item.stateOne
        holder.countTwoTextView.text = item.countTwo
        holder.stateTwoTextView.text = item.stateTwo

        holder.stateIconOne.setImageResource(iconMap[item.stateOne] ?: R.drawable.ic_default_state_one)
        holder.stateIconTwo.setImageResource(iconMap[item.stateTwo] ?: R.drawable.ic_default_state_one)
    }

    override fun getItemCount(): Int {
        return statisticsList.size
    }
}