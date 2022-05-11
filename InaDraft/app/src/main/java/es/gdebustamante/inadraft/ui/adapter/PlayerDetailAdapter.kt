package es.gdebustamante.inadraft.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import es.gdebustamante.inadraft.R
import es.gdebustamante.inadraft.databinding.RowPlayerDetailBinding
import es.gdebustamante.inadraft.ui.view.vo.PlayerWithShieldVO
import es.gdebustamante.inadraft.util.loadGlideCenterImage

class PlayerDetailAdapter :
    ListAdapter<PlayerWithShieldVO, PlayerDetailAdapter.PlayerWithShieldDetailViewHolder>(
        PlayerWithShieldVODiffCallback
    ) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PlayerDetailAdapter.PlayerWithShieldDetailViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.row_player_detail, parent, false)
        return PlayerWithShieldDetailViewHolder(view)
    }

    override fun onBindViewHolder(
        holderWithShield: PlayerDetailAdapter.PlayerWithShieldDetailViewHolder,
        position: Int
    ) {
        holderWithShield.binding.bind(getItem(position))
    }

    inner class PlayerWithShieldDetailViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = RowPlayerDetailBinding.bind(view)
    }
}

private fun RowPlayerDetailBinding.bind(player: PlayerWithShieldVO) {
    rowPlayerDetailContent.apply {
        playerDetailCardLabelPlayerMedia.text = player.player.getMedia().toString()
        playerDetailCardLabelPlayerPosition.text = player.player.position
        playerDetailCardImgPlayerShield.loadGlideCenterImage(player.shield)
        playerDetailCardLabelPlayerName.text = player.player.name
        playerDetailCardImgPlayerPhoto.loadGlideCenterImage(player.player.photo)
        playerDetailCardLabelPlayerKickPunctuation.text = player.player.kick.toString()
        playerDetailCardLabelPlayerBodyPunctuation.text = player.player.body.toString()
        playerDetailCardLabelPlayerControlPunctuation.text = player.player.control.toString()
        playerDetailCardLabelPlayerGuardPunctuation.text = player.player.guard.toString()
        playerDetailCardLabelPlayerSpeedPunctuation.text = player.player.speed.toString()
        playerDetailCardLabelPlayerGutsPunctuation.text = player.player.guts.toString()

    }
}

object PlayerWithShieldVODiffCallback : DiffUtil.ItemCallback<PlayerWithShieldVO>() {
    override fun areItemsTheSame(
        oldItem: PlayerWithShieldVO,
        newItem: PlayerWithShieldVO
    ): Boolean =
        oldItem.player.id == newItem.player.id

    override fun areContentsTheSame(
        oldItem: PlayerWithShieldVO,
        newItem: PlayerWithShieldVO
    ): Boolean =
        oldItem == newItem

}