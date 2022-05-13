package es.gdebustamante.inadraft.ui.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import dagger.hilt.android.AndroidEntryPoint
import es.gdebustamante.inadraft.R
import es.gdebustamante.inadraft.databinding.FragmentHomeBinding
import es.gdebustamante.inadraft.ui.view.base.BaseFragment
import es.gdebustamante.inadraft.ui.viewmodel.InaDraftVM

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val viewModel: InaDraftVM by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = inflateViewBinding(inflater, container)
        binding?.apply {
            setupDrawerWithFragmentToolbar(homeFragmentToolbarTop)
        }
        return binding?.root
    }

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding = FragmentHomeBinding.inflate(inflater, container, false)
}