package es.gdebustamante.inadraft.ui.view.base

import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModel

abstract class BaseActivity<TypeViewModel : ViewModel> : AppCompatActivity() {

//    private val viewModel : TypeViewModel by viewModels()
//    abstract fun getToolbarBase() : Toolbar?
}