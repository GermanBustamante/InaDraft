package es.gdebustamante.inadraft.ui.view.bindingExtension

import androidx.navigation.findNavController
import es.gdebustamante.inadraft.databinding.FragmentFormationListBinding
import es.gdebustamante.inadraft.domain.FormationBO
import es.gdebustamante.inadraft.ui.adapter.FormationAdapter
import es.gdebustamante.inadraft.ui.view.fragment.Formation442Fragment.Companion.FORMATION_4_4_2
import es.gdebustamante.inadraft.ui.view.fragment.FormationListFragmentDirections

//region public methods

/**
 * Dado una lista de formaciones y un adapter, actualiza un recyclerView linkeado a ese adapter con esa lista
 */
fun FragmentFormationListBinding.onFormationListChanged(
    formations: List<FormationBO>,
    adapter: FormationAdapter,
) {
    adapter.submitList(formations)
}

/**
 * Linkea el listado de formaciones con el adapter pasado por parámetro
 */
fun FragmentFormationListBinding.setupRecyclerView(adapter: FormationAdapter) {
    formationListFragmentListOfFormations.adapter = adapter
}

/**
 * Dado una formación seleccionada de una lista, navega a un [Fragment] o otro en función del clickado
 */
fun FragmentFormationListBinding.onFormationSelected(formation: FormationBO) {
    root.findNavController().navigate(
        when (formation.name) {
            FORMATION_4_4_2 -> FormationListFragmentDirections.actionFormationListFragmentToFormation442Fragment(
                formation.id)
            else -> FormationListFragmentDirections.actionFormationListFragmentToFormation442Fragment(
                formation.id)
        })
}

//endregion