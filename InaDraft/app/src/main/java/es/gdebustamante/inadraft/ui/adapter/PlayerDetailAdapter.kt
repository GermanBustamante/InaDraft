package es.gdebustamante.inadraft.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import es.gdebustamante.inadraft.R
import es.gdebustamante.inadraft.databinding.RowPlayerDetailBinding
import es.gdebustamante.inadraft.domain.PlayerBO
import es.gdebustamante.inadraft.util.loadGlideCenterImage

/**
 * Clase utilizada para pintado de un listado de jugadores en un RecyclerView
 *
 * Esta clase extiende de ListAdapter, la cual usará un DiffUtil personalizado [PlayerBODiffCallback] para la optimización de esta lista y animaciones,
 * el listado de jugadores será pasado a traves del método [ListAdapter.submitList]
 *
 *
 * @author Germán De Bustamante Conde
 *
 * @see <a href = "https://developer.android.com/reference/androidx/recyclerview/widget/ListAdapter">Diff Util</a>
 * @see <a href="https://developer.android.com/reference/androidx/recyclerview/widget/RecyclerView.Adapter">Adapter</a>
 * @see <a href="https://medium.com/geekculture/android-listadapter-a-better-implementation-for-the-recyclerview-1af1826a7d21">Recycler View with List Adapter</a>
 */
class PlayerDetailAdapter : ListAdapter<PlayerBO, PlayerDetailViewHolder>(
    PlayerBODiffCallback
) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): PlayerDetailViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.row_player_detail, parent, false)
        return PlayerDetailViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: PlayerDetailViewHolder,
        position: Int,
    ) {
        holder.binding.bind(getItem(position))
    }


}

//region viewholder

/**
 * ViewHolder personalizado para pintado de un jugador en la lista
 */
class PlayerDetailViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val binding = RowPlayerDetailBinding.bind(view)
}

//endregion

//region diffCallback

/**
 * DiffCallback personalizado para mejorar el rendimiento y agregar animaciones por defecto a la lista
 */
object PlayerBODiffCallback : DiffUtil.ItemCallback<PlayerBO>() {
    override fun areItemsTheSame(
        oldItem: PlayerBO,
        newItem: PlayerBO,
    ): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(
        oldItem: PlayerBO,
        newItem: PlayerBO,
    ): Boolean =
        oldItem == newItem

}

//endregion

//region private methods

/**
 * Dado un jugador en un item específico, pinta los datos de este en dicha fila
 */
private fun RowPlayerDetailBinding.bind(player: PlayerBO) {
    rowPlayerDetailContent.apply {
        playerDetailCardLabelPlayerMedia.text = player.average.toString()
        playerDetailCardLabelPlayerPosition.text = player.position.name
        playerDetailCardImgPlayerShield.loadGlideCenterImage(player.team.shield)
        playerDetailCardLabelPlayerName.text = player.name.uppercase()
        playerDetailCardImgPlayerPhoto.loadGlideCenterImage(player.photo)
        playerDetailCardLabelPlayerKickPunctuation.text = player.kick.toString()
        playerDetailCardLabelPlayerBodyPunctuation.text = player.body.toString()
        playerDetailCardLabelPlayerControlPunctuation.text = player.control.toString()
        playerDetailCardLabelPlayerGuardPunctuation.text = player.guard.toString()
        playerDetailCardLabelPlayerSpeedPunctuation.text = player.speed.toString()
        playerDetailCardLabelPlayerGutsPunctuation.text = player.guts.toString()

    }
}

//endregion