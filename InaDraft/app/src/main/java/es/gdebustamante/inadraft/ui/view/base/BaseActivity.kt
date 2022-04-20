package es.gdebustamante.inadraft.ui.view.base

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

abstract class BaseActivity : AppCompatActivity() {

    abstract fun getToolbarBase() : Toolbar?
}