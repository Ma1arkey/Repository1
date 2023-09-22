package com.dedenko.ui.adapters



import android.media.Image
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dedenko.data.response.teams.Team
import com.dedenko.databinding.RcvLytEplTeamsBinding

import com.dedenko.utils.loadSvg
//import kotlinx.android.synthetic.main.rcv_lyt_premier_league_teams.view.*


class EPLTeamAdapter (private val onClickListener: OnTeamItemClickListener) : ListAdapter<Team, EPLTeamAdapter.PremierLeagueViewHolder>(
    PremierLeagueDiffCallback()
) {


    class PremierLeagueViewHolder private constructor(private val binding: RcvLytEplTeamsBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(item: Team?){
            if (item != null) {

                binding.root.apply {
                    transitionName = item.crestUrl
                }

                binding.imgClub.apply {
                    loadSvg(item.crestUrl)
                }

                binding.txtClubName.text = item.name
            }
        }

        companion object{
            fun from(parent: ViewGroup) : PremierLeagueViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RcvLytEplTeamsBinding.inflate(layoutInflater, parent, false)
                return PremierLeagueViewHolder(binding)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PremierLeagueViewHolder {
        return PremierLeagueViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: PremierLeagueViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            holder.bind(item)
        }
        holder.itemView.setOnClickListener {
            if (item != null) {
                onClickListener.onClickTeam(item, it as ConstraintLayout)
            }
        }
    }

    class OnTeamItemClickListener(val clickListener: (team: Team, view: ConstraintLayout) -> Unit){
        fun onClickTeam(team: Team, view: ConstraintLayout) = clickListener(team, view)
    }

    class  PremierLeagueDiffCallback : DiffUtil.ItemCallback<Team>() {

        override fun areItemsTheSame(oldItem: Team, newItem: Team): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Team, newItem: Team): Boolean {
            return oldItem == newItem
        }

    }

}