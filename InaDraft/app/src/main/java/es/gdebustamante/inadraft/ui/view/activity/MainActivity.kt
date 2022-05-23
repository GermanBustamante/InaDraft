package es.gdebustamante.inadraft.ui.view.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.navigation.NavigationView
import dagger.hilt.android.AndroidEntryPoint
import es.gdebustamante.inadraft.R
import es.gdebustamante.inadraft.databinding.ActivityMainBinding
import es.gdebustamante.inadraft.ui.view.base.BaseActivity
import es.gdebustamante.inadraft.ui.viewmodel.MainAcvitiyVM

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private var binding: ActivityMainBinding? = null
    private val navController by lazy { getActivityNavController() }
    private val viewModel : MainAcvitiyVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        viewModel.init()
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, binding?.root)
                || super.onSupportNavigateUp()
    }

    override fun getActionBarBase(): ActionBar? = supportActionBar

    override fun getNavDrawer() : NavigationView? = binding?.activityMainDrawerStart

    override fun getDrawerLayout() : DrawerLayout? = binding?.root

    override fun onBackPressed() {
        binding?.apply {
            if (root.isDrawerOpen(GravityCompat.START)) {
                root.closeDrawer(GravityCompat.START)
            } else {
                super.onBackPressed()
            }
        }
    }

    private fun getActivityNavController(): NavController =
        (supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment).navController
}