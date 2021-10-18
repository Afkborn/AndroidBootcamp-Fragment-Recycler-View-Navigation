package com.bilgehankalay.fragmentrecyclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bilgehankalay.fragmentrecyclerview.databinding.FragmentDetailRecyclerViewBinding


class DetailRecyclerView : Fragment() {
    private var _binding : FragmentDetailRecyclerViewBinding? = null
    private val binding get() = _binding!!
    private val args : DetailRecyclerViewArgs by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentDetailRecyclerViewBinding.inflate(inflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val gelenModel = args.model
        binding.detailModelNameTextView.text = gelenModel.name
        binding.detailModelImageView.setImageResource(gelenModel.modelPic)

        binding.backFab.setOnClickListener {
            findNavController().navigate(R.id.detail_to_list)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}