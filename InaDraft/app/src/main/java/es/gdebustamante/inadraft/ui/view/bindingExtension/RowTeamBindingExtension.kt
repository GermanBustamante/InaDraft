package es.gdebustamante.inadraft.ui.view.bindingExtension

import es.gdebustamante.inadraft.data.entities.bo.TeamBO
import es.gdebustamante.inadraft.databinding.RowTeamBinding
import es.gdebustamante.inadraft.util.loadGlideCenterImage

fun RowTeamBinding.bind(team: TeamBO) {
    rowTeamImgOfTeam.loadGlideCenterImage(team.shield)
    rowTeamLabelTeamName.text = team.name
}