package es.gdebustamante.inadraft.ui.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import es.gdebustamante.inadraft.databinding.FragmentFormation442Binding
import es.gdebustamante.inadraft.ui.view.base.BaseFragment
import es.gdebustamante.inadraft.ui.view.bindingExtension.setupCardsPositions
import es.gdebustamante.inadraft.ui.view.bindingExtension.setupListeners

class Formation442Fragment : BaseFragment<FragmentFormation442Binding>() {

    //region class attributes

    private val args: Formation442FragmentArgs  by navArgs()

    //endregion

    //region override methods

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = inflateViewBinding(inflater, container)
        binding?.apply {
            setupDrawerWithFragmentToolbar(contentFormationBase.formationFragmentToolbarTop)
            setupCardsPositions()
            setupListeners()
        }
        return binding?.root
    }


    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): FragmentFormation442Binding =
        FragmentFormation442Binding.inflate(inflater, container, false)

    //endregion

}