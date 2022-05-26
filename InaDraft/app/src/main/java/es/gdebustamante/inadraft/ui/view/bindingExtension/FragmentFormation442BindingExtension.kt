package es.gdebustamante.inadraft.ui.view.bindingExtension

import android.view.View
import es.gdebustamante.inadraft.databinding.FragmentFormation442Binding
import es.gdebustamante.inadraft.util.showSnackbar

//region public methods

fun FragmentFormation442Binding.setupCardsPositions() {
    formation442Goalkeeper.playerMiniCardLabelPlayerPositionPreview.text = "GK"
    formation442Defender1.playerMiniCardLabelPlayerPositionPreview.text = "DF"
    formation442Defender2.playerMiniCardLabelPlayerPositionPreview.text = "DF"
    formation442Defender3.playerMiniCardLabelPlayerPositionPreview.text = "DF"
    formation442Defender4.playerMiniCardLabelPlayerPositionPreview.text = "DF"
    formation442Midfielder1.playerMiniCardLabelPlayerPositionPreview.text = "MF"
    formationMidfielder2.playerMiniCardLabelPlayerPositionPreview.text = "MF"
    formationMidfielder3.playerMiniCardLabelPlayerPositionPreview.text = "MF"
    formation442Midfielder4.playerMiniCardLabelPlayerPositionPreview.text = "MF"
    formation442Forward1.playerMiniCardLabelPlayerPositionPreview.text = "FW"
    formation442Forward2.playerMiniCardLabelPlayerPositionPreview.text = "FW"
}

fun FragmentFormation442Binding.setupListeners() {
    formation442Goalkeeper.root.setOnClickListener { onPlayerCardClicked(it) }
    formation442Defender1.root.setOnClickListener { onPlayerCardClicked(it) }
    formation442Defender2.root.setOnClickListener { onPlayerCardClicked(it) }
    formation442Defender3.root.setOnClickListener { onPlayerCardClicked(it) }
    formation442Defender4.root.setOnClickListener { onPlayerCardClicked(it) }
    formation442Midfielder1.root.setOnClickListener { onPlayerCardClicked(it) }
    formationMidfielder2.root.setOnClickListener { onPlayerCardClicked(it) }
    formationMidfielder3.root.setOnClickListener { onPlayerCardClicked(it) }
    formation442Midfielder4.root.setOnClickListener { onPlayerCardClicked(it) }
    formation442Forward1.root.setOnClickListener { onPlayerCardClicked(it) }
    formation442Forward2.root.setOnClickListener { onPlayerCardClicked(it) }

}

fun FragmentFormation442Binding.onPlayerCardClicked(playerCard: View) {
    root.showSnackbar(playerCard.toString())
}

//endregion
