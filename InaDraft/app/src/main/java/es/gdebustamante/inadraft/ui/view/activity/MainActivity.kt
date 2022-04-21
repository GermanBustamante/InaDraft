package es.gdebustamante.inadraft.ui.view.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import es.gdebustamante.inadraft.R
import es.gdebustamante.inadraft.databinding.ActivityMainBinding
import es.gdebustamante.inadraft.ui.viewmodel.InaDraftVM

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    private val navController by lazy { getActivityNavController() }
    private val viewModel : InaDraftVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setupBtnNavView()
    }

    private fun setupBtnNavView() {
        binding?.activityMainBtnNavViewBottom?.setupWithNavController(navController)
    }

    private fun getActivityNavController(): NavController =
        (supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment).navController
}