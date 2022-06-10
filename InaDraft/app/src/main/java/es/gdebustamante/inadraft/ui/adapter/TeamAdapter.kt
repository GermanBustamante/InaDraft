package es.gdebustamante.inadraft.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import es.gdebustamante.inadraft.R
import es.gdebustamante.inadraft.databinding.RowTeamBinding
import es.gdebustamante.inadraft.domain.TeamBO
import es.gdebustamante.inadraft.util.loadGlideCenterImage

/**
 * Clase utilizada para pintado de un listado de Equipos en un RecyclerView
 *
 * Esta clase extiende de ListAdapter, la cual usará un DiffUtil personalizado [FormationBODiffCallback] para la optimización de esta lista y animaciones,
 * el listado de formaciones será pasado a traves del método [ListAdapter.submitList]
 *
 *
 * @author Germán De Bustamante Conde
 *
 * @property onTeamClickedListener función que se ejecutará al hacer click en un equipo de la lista
 *
 * @see <a href = "https://developer.android.com/reference/androidx/recyclerview/widget/ListAdapter">Diff Util</a>
 * @see <a href="https://developer.android.com/reference/androidx/recyclerview/widget/RecyclerView.Adapter">Adapter</a>
 * @see <a href="https://medium.com/geekculture/android-listadapter-a-better-implementation-for-the-recyclerview-1af1826a7d21">Recycler View with List Adapter</a>
 */
class TeamAdapter(private val onTeamClickedListener : (TeamBO) -> Unit) : ListAdapter<TeamBO, TeamViewHolder>(TeamDiffCallback){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_team, parent, false)
        return TeamViewHolder(view)
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        holder.binding.bind(getItem(position), onTeamClickedListener)
    }

}

//region viewholder

/**
 * ViewHolder personalizado para pintado de una formación de la lista
 */
class TeamViewHolder(view: View) : RecyclerView.ViewHolder(view)  {
    val binding = RowTeamBinding.bind(view)
}

//endregion

//region diffcallback

/**
 * DiffCallback personalizado para mejorar el rendimiento y agregar animaciones por defecto a la lista
 */
object TeamDiffCallback: DiffUtil.ItemCallback<TeamBO>() {
    override fun areItemsTheSame(oldItem: TeamBO, newItem: TeamBO): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: TeamBO, newItem: TeamBO): Boolean =
        oldItem == newItem

}

//endregion

//region private functions

/**
 * Dado una formación en un item específico, pinta los datos de esta en dicha fila
 */
private fun RowTeamBinding.bind(team: TeamBO, onTeamClickedListener: (TeamBO) -> Unit) {
    rowTeamImgOfTeam.loadGlideCenterImage(team.shield)
    rowTeamLabelTeamName.text = team.name
    root.setOnClickListener { onTeamClickedListener(team) }
}

//endregion


