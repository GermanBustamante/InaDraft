package es.gdebustamante.inadraft.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import es.gdebustamante.inadraft.R
import es.gdebustamante.inadraft.data.entities.bo.TeamBO
import es.gdebustamante.inadraft.databinding.RowTeamBinding
import es.gdebustamante.inadraft.ui.view.bindingExtension.bind

class TeamAdapter : ListAdapter<TeamBO, TeamAdapter.TeamViewHolder>(TeamDiffCallback){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_team, parent, false)
        return TeamViewHolder(view)
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        with(holder){
            binding.bind(getItem(position))
        }
    }

    inner class TeamViewHolder(view: View) : RecyclerView.ViewHolder(view)  {
        val binding = RowTeamBinding.bind(view)
    }
}



object TeamDiffCallback: DiffUtil.ItemCallback<TeamBO>() {
    override fun areItemsTheSame(oldItem: TeamBO, newItem: TeamBO): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: TeamBO, newItem: TeamBO): Boolean =
        oldItem == newItem

}
