package com.example.parcial02.ui.mountain.principal

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.Button
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.parcial02.R
import com.example.parcial02.data.model.MountainModel
import com.example.parcial02.databinding.FragmentPrincipalBinding
import com.example.parcial02.ui.mountain.principal.recyclerview.MountainRecyclerViewAdapter
import com.example.parcial02.ui.mountain.viewmodel.MountainViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.security.Principal

class PrincipalFragment : Fragment() {
    private lateinit var floatingActionButton: FloatingActionButton
    private lateinit var CardView: CardView
    private lateinit var Button: Button

    private lateinit var binding: FragmentPrincipalBinding
    private lateinit var adapter: MountainRecyclerViewAdapter

    private val mountainViewModel: MountainViewModel by activityViewModels{
        MountainViewModel.Factory
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedState: Bundle?
    ): View {
        binding = FragmentPrincipalBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView(view)

        binding.floatingActionButton.setOnClickListener {
            mountainViewModel.clearData()
            it.findNavController().navigate(R.id.action_fragment_first_to_fragment_third)
        }

    }


    private fun showSelectedItem(mountain: MountainModel) {
        mountainViewModel.setSelectedMountain(mountain)
        findNavController().navigate(R.id.action_fragment_first_to_fragment_second)
    }

    private fun displayMovies() {
        val mountains = mountainViewModel.getMountain()
        Log.d("FragmentFirst", "Mountains: $mountains")
        adapter.setData(mountains)
        adapter.notifyDataSetChanged()
    }


    private fun setRecyclerView(view: View) {
        binding.recyclerView.layoutManager = LinearLayoutManager(view.context)

        adapter = MountainRecyclerViewAdapter { selectedMovie -> showSelectedItem(selectedMovie) }

        binding.recyclerView.adapter = adapter
        displayMovies()

    }
}

