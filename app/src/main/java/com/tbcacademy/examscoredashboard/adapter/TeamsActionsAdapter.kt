package com.tbcacademy.examscoredashboard.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tbcacademy.examscoredashboard.databinding.ItemTeamsActionsBinding
import com.tbcacademy.examscoredashboard.models.Summary


class TeamsActionsAdapter(private val summary: List<Summary>) :
    RecyclerView.Adapter<TeamsActionsAdapter.ViewHolder>() {

    var viewPool = RecyclerView.RecycledViewPool()




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemTeamsActionsBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun getItemCount() = summary.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
        holder.nestedChild()
    }


    inner class ViewHolder(private val binding: ItemTeamsActionsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private lateinit var child: Summary
        fun bind() {
            child = summary[adapterPosition]
            itemView.apply {
                // binding.tvActionTime.text = child.actionTime

            }

        }

        @SuppressLint("WrongConstant")
        fun nestedChild() {
            itemView.apply {
                val parent = summary[adapterPosition]

                binding.recyclerChild.layoutManager =
                    LinearLayoutManager(binding.recyclerChild.context, LinearLayout.VERTICAL, false)
                binding.recyclerChild.adapter = TeamsChildAdapter(parent.team1Action)
                //binding.team1ActionRecycler.recycledViewPool = viewPool
                viewPool = binding.recyclerChild.recycledViewPool


            }

        }
    }
}