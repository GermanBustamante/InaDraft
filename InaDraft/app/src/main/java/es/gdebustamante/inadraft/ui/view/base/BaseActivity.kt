package es.gdebustamante.inadraft.ui.view.base

import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.ui.AppBarConfiguration
import com.google.android.material.navigation.NavigationView

abstract class BaseActivity : AppCompatActivity() {

    abstract fun getActionBarBase() : ActionBar?

    abstract fun getNavDrawer(): NavigationView?

    abstract fun getDrawerLayout(): DrawerLayout?

    abstract fun getAppBarConfigurationActivity() : AppBarConfiguration
}