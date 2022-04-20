package es.gdebustamante.inadraft.util

import android.app.Activity
import android.widget.Toast

fun Activity.showToast(text : String, lenght : Int = Toast.LENGTH_SHORT) = Toast.makeText(this, text, lenght).show()
