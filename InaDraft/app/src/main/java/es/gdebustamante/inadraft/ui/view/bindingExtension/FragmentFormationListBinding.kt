package es.gdebustamante.inadraft.ui.view.bindingExtension

import androidx.navigation.findNavController
import es.gdebustamante.inadraft.R
import es.gdebustamante.inadraft.databinding.FragmentFormationListBinding
import es.gdebustamante.inadraft.domain.FormationBO
import es.gdebustamante.inadraft.ui.adapter.FormationAdapter
import es.gdebustamante.inadraft.ui.view.fragment.FormationListFragmentDirections

//region public methods

fun FragmentFormationListBinding.onFormationListChanged(
    formations: List<FormationBO>,
    adapter: FormationAdapter,
) {
    adapter.submitList(formations)
}

fun FragmentFormationListBinding.setupRecyclerView(adapter: FormationAdapter) {
    formationListFragmentListOfFormations.adapter = adapter
}


fun FragmentFormationListBinding.onFormationSelected(formation: FormationBO) {
    root.findNavController().navigate(
        when (formation.name) {
        "4-4-2" -> FormationListFragmentDirections.actionFormationListFragmentToFormation442Fragment(formation.id)
        else -> FormationListFragmentDirections.actionFormationListFragmentToFormation442Fragment(formation.id)
    })
}

//endregion