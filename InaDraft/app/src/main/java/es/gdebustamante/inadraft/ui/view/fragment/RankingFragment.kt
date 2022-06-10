package es.gdebustamante.inadraft.ui.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import es.gdebustamante.inadraft.databinding.FragmentRankingBinding
import es.gdebustamante.inadraft.ui.adapter.GameAdapter
import es.gdebustamante.inadraft.ui.view.base.BaseFragment
import es.gdebustamante.inadraft.ui.viewmodel.RankingVM

/**
 * Pantalla en la que se muestran un listado de las partidas guardadas con sus puntuaciones
 */
@AndroidEntryPoint
class RankingFragment : BaseFragment<FragmentRankingBinding>() {

    //region class attributes

    private var adapter : GameAdapter? = null
    private val viewModel : RankingVM by viewModels()

    //endregion

    //region override methods

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = inflateViewBinding(inflater, container)
        binding?.apply {
            setupDrawerWithFragmentToolbar(rankingFragmentToolbarTop)
            adapter = GameAdapter().also {
                rankingFragmentListOfGames.adapter = it
            }
        }
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupVMObservers()
        viewModel.loadBestGames()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        adapter = null
        binding = null
    }

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): FragmentRankingBinding =
        FragmentRankingBinding.inflate(inflater, container, false)

    //endregion

    //region private methods

    /**
     * Observa los liveData del VM y su comportamiento cuando estos cambiem
     */
    private fun setupVMObservers() {
        viewModel.games.observe(viewLifecycleOwner){
            binding?.rankingFragmentProgressIndicatorLoadingBestGames?.visibility = View.GONE
            adapter?.submitList(it)
        }
    }

    //endregion
}