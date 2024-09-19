package com.firstgroup.cmisentinelprimemobile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class StatisticItem(val countOne: String, val stateOne: String, val countTwo: String, val stateTwo: String)

class StatisticsAdapter(private val statisticsList: List<StatisticItem>) :
    RecyclerView.Adapter<StatisticsAdapter.StatisticsViewHolder>() {

    class StatisticsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val countOneTextView: TextView = view.findViewById(R.id.tvCount1)
        val stateOneTextView: TextView = view.findViewById(R.id.tvStateName1)
        val countTwoTextView: TextView = view.findViewById(R.id.tvCount2)
        val stateTwoTextView: TextView = view.findViewById(R.id.tvStateName2)
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
    }

    override fun getItemCount(): Int {
        return statisticsList.size
    }
}
