package com.bilgehankalay.fragmentrecyclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bilgehankalay.fragmentrecyclerview.databinding.FragmentListRecyclerViewBinding

class ListRecyclerView : Fragment() {
    private var _binding : FragmentListRecyclerViewBinding?= null
    private val binding get() = _binding!!
    private var birOncekiSecilenModel : Model? =null
    private var secilenModel : Model? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListRecyclerViewBinding.inflate(inflater)
        // Inflate the layout for this fragment

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.deleteFab.visibility = View.INVISIBLE
        binding.forwardFab.visibility = View.INVISIBLE
        val modelList = arrayListOf(
            Model(R.drawable.uc_k,"Uc K"),
            Model(R.drawable.dort_k,"Dort K"),
            Model(R.drawable.bes_k,"Bes K")
        )
        val modelRecyclerAdapter = ModelRecyclerAdapter(modelList)
        binding.modelRecyclerView.adapter = modelRecyclerAdapter
        binding.modelRecyclerView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        binding.modelRecyclerView.setHasFixedSize(true)
        modelRecyclerAdapter.onItemClick = ::modelSec

        binding.forwardFab.setOnClickListener {
            if (secilenModel != null){
                val action = ListRecyclerViewDirections.listToDetail(secilenModel!!)
                findNavController().navigate(action)
            }
        }
        binding.deleteFab.setOnClickListener {
            if (secilenModel != null){
                val silineckIndex = modelList.indexOf(secilenModel)
                modelList.removeAt(silineckIndex)
                modelRecyclerAdapter.modelListGuncelle(modelList)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    fun modelSec(gelenModel : Model){
        if (birOncekiSecilenModel == gelenModel){
            binding.deleteFab.visibility = View.INVISIBLE
            binding.forwardFab.visibility = View.INVISIBLE
            birOncekiSecilenModel = null
        }
        else{
            secilenModel = gelenModel
            if (secilenModel != null){
                binding.forwardFab.visibility = View.VISIBLE
                binding.deleteFab.visibility = View.VISIBLE
                birOncekiSecilenModel = secilenModel
            }

        }

    }

}