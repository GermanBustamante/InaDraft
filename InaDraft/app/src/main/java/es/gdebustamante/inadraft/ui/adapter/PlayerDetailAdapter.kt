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

class PlayerDetailViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val binding = RowPlayerDetailBinding.bind(view)
}

//endregion

//region diffCallback

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