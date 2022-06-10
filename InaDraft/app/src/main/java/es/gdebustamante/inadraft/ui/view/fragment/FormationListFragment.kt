package es.gdebustamante.inadraft.ui.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import es.gdebustamante.inadraft.databinding.FragmentFormationListBinding
import es.gdebustamante.inadraft.ui.adapter.FormationAdapter
import es.gdebustamante.inadraft.ui.view.base.BaseFragment
import es.gdebustamante.inadraft.ui.view.bindingExtension.onFormationListChanged
import es.gdebustamante.inadraft.ui.view.bindingExtension.onFormationSelected
import es.gdebustamante.inadraft.ui.view.bindingExtension.setupRecyclerView
import es.gdebustamante.inadraft.ui.viewmodel.FormationListVM

/**
 * Pantalla en la que se muestran un listado de formaciones y el usuario puede clickar en una de ellas, una vez clickado, navega a
 * un Fragment dependiendo de la formación clickada
 */
@AndroidEntryPoint
class FormationListFragment : BaseFragment<FragmentFormationListBinding>() {

    //region class attributes

    private val viewModel: FormationListVM by viewModels()
    private var adapter: FormationAdapter? = null

    //endregion

    //region override methods

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = inflateViewBinding(inflater, container)

        binding?.apply {
            setupDrawerWithFragmentToolbar(formationListFragmentToolbarTop)
            adapter = FormationAdapter { onFormationSelected(it) }.also {
                setupRecyclerView(it)
            }
        }
        return binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupVMObservers()
        viewModel.loadFormations()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        adapter = null
    }

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): FragmentFormationListBinding =
        FragmentFormationListBinding.inflate(inflater, container, false)

    //endregion

    //region private methods

    /**
     * Observa los liveData del VM y su comportamiento cuando estos cambiem
     */
    private fun setupVMObservers() {
        viewModel.formations.observe(viewLifecycleOwner) {
            adapter?.let { adapter ->
                binding?.onFormationListChanged(it, adapter)
            }
        }
    }

    //endregion
}
