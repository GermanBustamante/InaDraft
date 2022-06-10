package es.gdebustamante.inadraft.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import es.gdebustamante.inadraft.R
import es.gdebustamante.inadraft.databinding.RowFormationBinding
import es.gdebustamante.inadraft.domain.FormationBO
import es.gdebustamante.inadraft.util.loadGlideCenterImage

/**
 * Clase utilizada para pintado de un listado de Formaciones en un RecyclerView
 *
 * Esta clase extiende de ListAdapter, la cual usará un DiffUtil personalizado [FormationBODiffCallback] para la optimización de esta lista y animaciones,
 * el listado de formaciones será pasado a traves del método [ListAdapter.submitList]
 *
 *
 * @author Germán De Bustamante Conde
 * @property onFormationSelectedListener función que se ejecutará al hacer click en una formación de la lista
 *
 * @see <a href = "https://developer.android.com/reference/androidx/recyclerview/widget/ListAdapter">Diff Util</a>
 * @see <a href="https://developer.android.com/reference/androidx/recyclerview/widget/RecyclerView.Adapter">Adapter</a>
 * @see <a href="https://medium.com/geekculture/android-listadapter-a-better-implementation-for-the-recyclerview-1af1826a7d21">Recycler View with List Adapter</a>
 */
class FormationAdapter(private val onFormationSelectedListener : (FormationBO) -> Unit) :
    ListAdapter<FormationBO, FormationViewHolder>(
        FormationBODiffCallback
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FormationViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.row_formation, parent, false)
        return FormationViewHolder(view, onFormationSelectedListener)
    }

    override fun onBindViewHolder(holder: FormationViewHolder, position: Int) {
        holder.binding.bind(getItem(position))
    }

    /**
     * Devuelve una formación del listado actual
     * @param position
     * @return
     */
    fun getFormation(position: Int): FormationBO = currentList[position]
}


//region viewholder

/**
 * ViewHolder personalizado para pintado de una formación de la lista
 */
class FormationViewHolder(view: View, onFormationSelectedListener: (FormationBO) -> Unit) : RecyclerView.ViewHolder(view) {
    val binding = RowFormationBinding.bind(view)

    init {
        itemView.setOnClickListener{
            if (bindingAdapterPosition != RecyclerView.NO_POSITION){
                val formation =
                    (bindingAdapter as? FormationAdapter)?.getFormation(bindingAdapterPosition)
                if (formation != null){
                    onFormationSelectedListener(formation)
                }
            }
        }
    }
}

//endregion

//region diffcallback

/**
 * DiffCallback personalizado para mejorar el rendimiento y agregar animaciones por defecto a la lista
 */
object FormationBODiffCallback : DiffUtil.ItemCallback<FormationBO>() {
    override fun areItemsTheSame(oldItem: FormationBO, newItem: FormationBO): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: FormationBO, newItem: FormationBO): Boolean =
        oldItem == newItem

}

//endregion

//region private functions

/**
 * Dado una formación en un item específico, pinta los datos de esta en dicha fila
 */
private fun RowFormationBinding.bind(formation: FormationBO) {
    rowFormationFragmentImgFormationPreview.loadGlideCenterImage(formation.photo)
    rowFormationLabelFormationName.text = formation.name
}

//endregion
