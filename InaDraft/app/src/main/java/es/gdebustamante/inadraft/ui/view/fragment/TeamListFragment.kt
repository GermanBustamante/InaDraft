package es.gdebustamante.inadraft.ui.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import es.gdebustamante.inadraft.data.api.APIService
import es.gdebustamante.inadraft.data.entities.bo.TeamBO
import es.gdebustamante.inadraft.data.mapper.toBO
import es.gdebustamante.inadraft.databinding.FragmentTeamListBinding
import es.gdebustamante.inadraft.ui.adapter.TeamAdapter
import es.gdebustamante.inadraft.ui.view.base.BaseFragment
import es.gdebustamante.inadraft.ui.viewmodel.InaDraftVM
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TeamListFragment : BaseFragment<FragmentTeamListBinding>() { // TODO PASAR A FICHERO DE EXTENSION

    private val viewModel : InaDraftVM by activityViewModels()
    private val adapter = TeamAdapter()

    companion object {
        @JvmStatic
        fun newInstance() = TeamListFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = inflateViewBinding(inflater,container)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        viewModel.teamList.observe(viewLifecycleOwner, this::onTeamListLoaded)
        super.onViewCreated(view, savedInstanceState)
//        viewModel.getTeamsList()
        lifecycleScope.launch(Dispatchers.IO){
            val products = APIService.getAPIService().getTeams()
            val pro2 = products.body()?.map { it.toBO() }
            withContext(Dispatchers.Main){
                adapter.submitList(pro2)
            }
        }
    }

    private fun onTeamListLoaded(teamList: List<TeamBO>) {
        binding?.teamListFragmentSlideListOfTeams?.adapter = adapter
        adapter.submitList(teamList)
    }

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentTeamListBinding = FragmentTeamListBinding.inflate(inflater, container, false)
}