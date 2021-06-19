package com.tbcacademy.examscoredashboard.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tbcacademy.examscoredashboard.databinding.ItemTeamsActionsSummaryBinding
import com.tbcacademy.examscoredashboard.models.Team1Action

class TeamsChildAdapter(private val actions: List<Team1Action>) :
    RecyclerView.Adapter<TeamsChildAdapter.ViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemTeamsActionsSummaryBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()

    }


    override fun getItemCount() = actions.size


    inner class ViewHolder(private val binding: ItemTeamsActionsSummaryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private lateinit var child: Team1Action
        fun bind() {
            child = actions[adapterPosition]
            itemView.apply {
                binding.tvActionName.text = child.actionType.toString()
                binding.tvPlayerName.text = child.action.player.playerName
                Glide.with(this).load(child.action.player.playerImage).into(binding.ivPlayerImage)

            }

        }

    }

}