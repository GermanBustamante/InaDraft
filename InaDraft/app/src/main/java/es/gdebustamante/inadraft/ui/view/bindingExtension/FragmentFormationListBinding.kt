package es.gdebustamante.inadraft.ui.view.bindingExtension

import es.gdebustamante.inadraft.databinding.FragmentFormationListBinding
import es.gdebustamante.inadraft.domain.FormationBO
import es.gdebustamante.inadraft.ui.adapter.FormationAdapter

fun FragmentFormationListBinding.onFormationListChanged(
    formations: List<FormationBO>,
    adapter: FormationAdapter
) {
    adapter.submitList(formations)
}