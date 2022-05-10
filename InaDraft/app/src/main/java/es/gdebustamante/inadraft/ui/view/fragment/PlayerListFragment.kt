package es.gdebustamante.inadraft.ui.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.hilt.android.AndroidEntryPoint
import es.gdebustamante.inadraft.databinding.FragmentPlayerListBinding
import es.gdebustamante.inadraft.ui.view.base.BaseFragment

@AndroidEntryPoint
class PlayerListFragment : BaseFragment<FragmentPlayerListBinding>() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = inflateViewBinding(inflater, container)
        return binding?.root
    }

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentPlayerListBinding = FragmentPlayerListBinding.inflate(inflater, container, false)


}