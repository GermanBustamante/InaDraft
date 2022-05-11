package es.gdebustamante.inadraft.ui.view.bindingExtension

import es.gdebustamante.inadraft.databinding.FragmentPlayerInfoListBinding
import es.gdebustamante.inadraft.domain.PlayerBO
import es.gdebustamante.inadraft.ui.adapter.PlayerDetailAdapter
import es.gdebustamante.inadraft.ui.view.vo.toPlayerWithShieldVO

fun FragmentPlayerInfoListBinding.setupRecyclerView(adapter: PlayerDetailAdapter) {
    playerListFragmentSlideListOfPlayers.adapter = adapter
}

 fun FragmentPlayerInfoListBinding.onPlayerListChanged(playerList: List<PlayerBO>, urlShield: String, adapter: PlayerDetailAdapter) {
    adapter.submitList(playerList.map { it.toPlayerWithShieldVO(urlShield) })
}