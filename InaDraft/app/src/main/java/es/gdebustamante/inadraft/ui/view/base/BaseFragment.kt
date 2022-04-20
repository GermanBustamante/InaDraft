package es.gdebustamante.inadraft.ui.view.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<TypeBinding : ViewBinding> : Fragment() {

    protected var binding: TypeBinding? = null

    protected abstract fun inflateViewBinding(inflater: LayoutInflater, container: ViewGroup?): TypeBinding

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

    protected fun getActivityToolbar(): Toolbar? {
        return (activity as? BaseActivity)?.getToolbarBase()
    }
}