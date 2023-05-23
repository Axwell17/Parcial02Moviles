package com.example.parcial02.ui.mountain

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.parcial02.R
import com.example.parcial02.databinding.FragmentInfoBinding
import com.example.parcial02.ui.mountain.viewmodel.MountainViewModel

class InfoFragment : Fragment() {
    private lateinit var binding: FragmentInfoBinding
    private lateinit var mountainViewModel: MountainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mountainViewModel = ViewModelProvider(requireActivity()).get(MountainViewModel::class.java)
        binding.viewmodel = mountainViewModel

        binding.buttonBack.setOnClickListener{
            it.findNavController().navigate(R.id.action_fragment_second_to_fragment_principal)
        }

    }
}