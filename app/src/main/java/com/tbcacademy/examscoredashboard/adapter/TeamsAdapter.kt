package com.tbcacademy.examscoredashboard.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tbcacademy.examscoredashboard.databinding.ItemTeamsInGeneralBinding
import com.tbcacademy.examscoredashboard.models.Teams

class TeamsAdapter : RecyclerView.Adapter<TeamsAdapter.ViewHolder>() {

    private val teams = mutableListOf<Teams>()

    var viewPool = RecyclerView.RecycledViewPool()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemTeamsInGeneralBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
        holder.nestedChild()
    }

    override fun getItemCount() = teams.size

    fun setData(teams: Teams) {
       // this.teams.clear()
        this.teams.add(teams)
        notifyDataSetChanged()
    }


    inner class ViewHolder(private val binding: ItemTeamsInGeneralBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private lateinit var model: Teams
        @SuppressLint("SetTextI18n")
        fun bind() {
            model = teams[adapterPosition]
            itemView.apply {
                binding.tvDate.text = model.match.matchDate.toString()
                binding.tvStadium.text = model.match.stadiumAdress
                Glide.with(this).load(model.match.team1.teamImage).into(binding.ivTeamLogo)
                Glide.with(this).load(model.match.team2.teamImage).into(binding.ivTeam2Logo)
                binding.tvTeamName.text = model.match.team1.teamName
                binding.tvTeam2Name.text = model.match.team2.teamName
                binding.progressBarr.progress = model.match.team1.ballPosition
                binding.tvProgress.text = "${model.match.team1.ballPosition}%"
                binding.tvProgress2.text = "${model.match.team2.ballPosition}%"
                binding.tvScore.text = "${model.match.team1.score} : ${model.match.team2.score}"



            }

        }

       @SuppressLint("WrongConstant")
        fun nestedChild() {
            itemView.apply {
                val parent = teams[adapterPosition]

                binding.team1ActionRecycler.layoutManager = LinearLayoutManager(binding.team1ActionRecycler.context, LinearLayout.HORIZONTAL, false)
                binding.team1ActionRecycler.adapter = TeamsActionsAdapter(parent.match.matchSummary.summaries)
                //binding.team1ActionRecycler.recycledViewPool = viewPool
                viewPool = binding.team1ActionRecycler.recycledViewPool


            }

        }

    }
}