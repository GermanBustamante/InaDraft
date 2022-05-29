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

    fun getPlayer(position: Int) = currentList[position]

}

//region viewholders

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


