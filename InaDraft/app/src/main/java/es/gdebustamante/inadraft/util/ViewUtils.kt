package es.gdebustamante.inadraft.util

import android.view.View
import com.google.android.material.snackbar.Snackbar

fun View.showSnackbar (text: String, lenght: Int = Snackbar.LENGTH_SHORT) = Snackbar.make(this, text, lenght).show()