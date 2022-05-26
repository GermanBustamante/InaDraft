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

    fun getFormation(position: Int): FormationBO = currentList[position]
}


//region viewholder

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
object FormationBODiffCallback : DiffUtil.ItemCallback<FormationBO>() {
    override fun areItemsTheSame(oldItem: FormationBO, newItem: FormationBO): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: FormationBO, newItem: FormationBO): Boolean =
        oldItem == newItem

}

//endregion

//region private functions

private fun RowFormationBinding.bind(formation: FormationBO) {
    rowFormationFragmentImgFormationPreview.loadGlideCenterImage(formation.photo)
    rowFormationLabelFormationName.text = formation.name
}

//endregion
