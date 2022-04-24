package es.gdebustamante.inadraft.framework.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import es.gdebustamante.inadraft.R
import es.gdebustamante.inadraft.databinding.RowTeamBinding
import es.gdebustamante.inadraft.domain.entities.TeamBO
import es.gdebustamante.inadraft.framework.ui.view.bindingExtension.bind

class TeamAdapter(private val onTeamClickedListener : (TeamBO) -> Unit) : ListAdapter<TeamBO, TeamAdapter.TeamViewHolder>(TeamDiffCallback){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_team, parent, false)
        return TeamViewHolder(view)
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        holder.binding.bind(getItem(position), onTeamClickedListener)
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
