package es.gdebustamante.inadraft.framework.ui.view.bindingExtension

import es.gdebustamante.inadraft.databinding.RowTeamBinding
import es.gdebustamante.inadraft.domain.TeamBO
import es.gdebustamante.inadraft.util.loadGlideCenterImage

fun RowTeamBinding.bind(team: TeamBO, onTeamClickedListener: (TeamBO) -> Unit) {
    rowTeamImgOfTeam.loadGlideCenterImage(team.shield)
    rowTeamLabelTeamName.text = team.name
    root.setOnClickListener { onTeamClickedListener(team) }
}