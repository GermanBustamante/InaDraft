package es.gdebustamante.inadraft.util

import android.widget.Toast
import androidx.fragment.app.Fragment

fun Fragment.showToast(text : String, lenght : Int = Toast.LENGTH_SHORT) = Toast.makeText(requireContext(), text, lenght).show()
