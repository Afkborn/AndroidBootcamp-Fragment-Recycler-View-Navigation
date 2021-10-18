package com.bilgehankalay.fragmentrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bilgehankalay.fragmentrecyclerview.databinding.ModelCardTasarimBinding

class ModelRecyclerAdapter(private var modelList: ArrayList<Model>) : RecyclerView.Adapter<ModelRecyclerAdapter.ModelCardTasarim>() {
    class ModelCardTasarim(val modelCardTasarimBinding: ModelCardTasarimBinding) : RecyclerView.ViewHolder(modelCardTasarimBinding.root)
    var onItemClick : (Model) -> Unit = {}
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ModelRecyclerAdapter.ModelCardTasarim {
        val layoutInflater = LayoutInflater.from(parent.context)
        val modelCardTasarimBinding = ModelCardTasarimBinding.inflate(layoutInflater,parent,false)
        return ModelCardTasarim(modelCardTasarimBinding)
    }

    override fun onBindViewHolder(holder: ModelRecyclerAdapter.ModelCardTasarim, position: Int) {
        val model = modelList[position]
        holder.modelCardTasarimBinding.modelImageView.setImageResource(model.modelPic)
        holder.modelCardTasarimBinding.modelAdiTextview.text = model.name
        holder.modelCardTasarimBinding.root.setOnClickListener {
            onItemClick(model)

        }
    }

    override fun getItemCount(): Int {
        return modelList.size
    }

    fun modelListGuncelle(gelenListe : ArrayList<Model>){
        modelList = gelenListe
        notifyDataSetChanged()
    }

}