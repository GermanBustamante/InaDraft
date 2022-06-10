package es.gdebustamante.inadraft.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import es.gdebustamante.inadraft.R
import es.gdebustamante.inadraft.databinding.RowPlayerMiniGameBinding
import es.gdebustamante.inadraft.domain.PlayerBO
import es.gdebustamante.inadraft.util.loadGlideCenterImage

/**
 * Clase utilizada para pintado de un listado de jugadores sin detalle en un RecyclerView
 *
 * Esta clase extiende de ListAdapter, la cual usará un DiffUtil personalizado [PlayerBODiffCallback] para la optimización de esta lista y animaciones,
 * el listado de jugadores será pasado a traves del método [ListAdapter.submitList]
 *
 *
 * @author Germán De Bustamante Conde
 *
 * @property onPlayerSelectedListener función que se ejecutará al hacer click en un jugador de la lista

 * @see <a href = "https://developer.android.com/reference/androidx/recyclerview/widget/ListAdapter">Diff Util</a>
 * @see <a href="https://developer.android.com/reference/androidx/recyclerview/widget/RecyclerView.Adapter">Adapter</a>
 * @see <a href="https://medium.com/geekculture/android-listadapter-a-better-implementation-for-the-recyclerview-1af1826a7d21">Recycler View with List Adapter</a>
 */
class PlayerMiniGameAdapter(private val onPlayerSelectedListener : (PlayerBO) -> Unit) : ListAdapter<PlayerBO, PlayerMiniGameViewHolder>(
    PlayerBODiffCallback
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerMiniGameViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.row_player_mini_game, parent, false)
        return PlayerMiniGameViewHolder(view, onPlayerSelectedListener)
    }

    override fun onBindViewHolder(holder: PlayerMiniGameViewHolder, position: Int) {
        holder.binding.bind(getItem(position))
    }

    fun getPlayer(position: Int): PlayerBO = currentList[position]

}

//region viewholders

/**
 * ViewHolder personalizado para pintado de un jugador sin detalle en la lista
 */
class PlayerMiniGameViewHolder(view: View, onPlayerSelectedListener: (PlayerBO) -> Unit) : RecyclerView.ViewHolder(view) {
    val binding = RowPlayerMiniGameBinding.bind(view)

    init {
        itemView.setOnClickListener{
            if (bindingAdapterPosition != RecyclerView.NO_POSITION){
                val player = (bindingAdapter as? PlayerMiniGameAdapter)?.getPlayer(bindingAdapterPosition)
                if (player != null){
                    onPlayerSelectedListener(player)
                }
            }
        }
    }
}

//endregion

//region private methods

/**
 * Dado un jugador en un item específico, pinta los datos de este en dicha fila
 */
private fun RowPlayerMiniGameBinding.bind(player: PlayerBO) {
    rowPlayerMiniGameCardViewPlayerMiniCard.apply {
        playerMiniCardLabelPlayerMedia.text = player.average.toString()
        playerMiniCardLabelPlayerPosition.text = player.position.name
        playerMiniCardImgPlayerShield.loadGlideCenterImage(player.team.shield)
        playerMiniCardLabelPlayerName.text = player.firstName
        playerMiniCardImgPlayerPhoto.loadGlideCenterImage(player.photo)
    }
    rowPlayerMiniGameImgPlayerShield.loadGlideCenterImage(player.team.shield)
    rowPlayerMiniGameLabelPlayerShield.text = player.team.name
    rowPlayerMiniGameLabelPlayerPosition.text = player.position.getFullName()
}

//endregion


