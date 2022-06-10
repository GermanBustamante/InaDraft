package es.gdebustamante.inadraft.ui.view.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBar
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.google.android.material.navigation.NavigationView
import dagger.hilt.android.AndroidEntryPoint
import es.gdebustamante.inadraft.R
import es.gdebustamante.inadraft.databinding.ActivityMainBinding
import es.gdebustamante.inadraft.ui.view.base.BaseActivity
import es.gdebustamante.inadraft.ui.viewmodel.MainActivityVM

/**
 * Punto de inicio de la app que contendrá a las distintas pantallas [Fragment] por las que irá navegando
 */
@AndroidEntryPoint
class MainActivity : BaseActivity() {

    //region class attributes

    private var binding: ActivityMainBinding? = null
    private val navController by lazy { getActivityNavController() }
    private val viewModel: MainActivityVM by viewModels()
    private val appBarConfiguration by lazy {
        AppBarConfiguration(
            setOf(
                R.id.homeFragment,
                R.id.rankingFragment,
                R.id.aboutAppPreferenceFragment,
                R.id.infoTeamFragment
            ), getDrawerLayout()
        )
    }
    //endregion

    //region override methods

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                viewModel.isLoading.value
            }
        }
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, appBarConfiguration)

    }

    override fun getActionBarBase(): ActionBar? = supportActionBar

    override fun getNavDrawer(): NavigationView? = binding?.activityMainDrawerStart

    override fun getDrawerLayout(): DrawerLayout? = binding?.root

    override fun getAppBarConfigurationActivity(): AppBarConfiguration =
        appBarConfiguration

    override fun onBackPressed() {
        binding?.apply {
            if (root.isDrawerOpen(GravityCompat.START)) {
                root.closeDrawer(GravityCompat.START)
            } else {
                super.onBackPressed()
            }
        }
    }


    //endregion

    //region private methods

    private fun getActivityNavController(): NavController =
        (supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment).navController

    //endregion
}