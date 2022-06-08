package es.gdebustamante.inadraft.ui.view.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import androidx.viewbinding.ViewBinding
import es.gdebustamante.inadraft.R

abstract class BaseFragment<TypeBinding : ViewBinding> : Fragment() {

    protected var binding: TypeBinding? = null

    protected abstract fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): TypeBinding

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

    protected fun getActivityActionBar(): ActionBar? {
        return (requireActivity() as? BaseActivity)?.getActionBarBase()
    }

    protected fun setupDrawerWithFragmentToolbar(toolbar: Toolbar?) {
        val navController = findNavController()
        (requireActivity() as BaseActivity).apply {
            setSupportActionBar(toolbar)
            getNavDrawer()?.setupWithNavController(navController)
            NavigationUI.setupActionBarWithNavController(this, navController, getAppBarConfigurationActivity())
        }
    }
}