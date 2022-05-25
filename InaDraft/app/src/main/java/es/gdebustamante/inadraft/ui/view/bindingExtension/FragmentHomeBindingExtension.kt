package es.gdebustamante.inadraft.ui.view.bindingExtension

import androidx.navigation.findNavController
import es.gdebustamante.inadraft.R
import es.gdebustamante.inadraft.databinding.FragmentHomeBinding

fun FragmentHomeBinding.setListeners(){
    homeFragmentBtnPlay.setOnClickListener { root.findNavController().navigate(R.id.action_homeFragment_to_formationListFragment) }
}