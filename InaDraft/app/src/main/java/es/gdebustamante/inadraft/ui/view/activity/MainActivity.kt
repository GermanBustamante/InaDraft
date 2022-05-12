package es.gdebustamante.inadraft.ui.view.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.navigation.NavigationView
import dagger.hilt.android.AndroidEntryPoint
import es.gdebustamante.inadraft.R
import es.gdebustamante.inadraft.databinding.ActivityMainBinding
import es.gdebustamante.inadraft.ui.view.base.BaseActivity
import es.gdebustamante.inadraft.ui.viewmodel.InaDraftVM
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private var binding: ActivityMainBinding? = null
    private val navController by lazy { getActivityNavController() }
    private val viewModel : InaDraftVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        lifecycleScope.launch{}
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, binding?.root)
                || super.onSupportNavigateUp()
    }

    override fun getActionBarBase(): ActionBar? = supportActionBar

    override fun getNavDrawer() : NavigationView? = binding?.activityMainDrawerStart

    override fun getDrawerLayout() : DrawerLayout? = binding?.root

    private fun getActivityNavController(): NavController =
        (supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment).navController
}