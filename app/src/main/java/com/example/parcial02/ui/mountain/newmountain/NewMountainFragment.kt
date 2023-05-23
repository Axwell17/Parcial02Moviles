package com.example.parcial02.ui.mountain.newmountain

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.parcial02.R
import com.example.parcial02.data.height
import com.example.parcial02.data.model.MountainModel
import com.example.parcial02.databinding.FragmentNewMountainBinding
import com.example.parcial02.ui.mountain.viewmodel.MountainViewModel


class NewMountainFragment : Fragment() {
    private val mountainViewModel: MountainViewModel by activityViewModels{
        MountainViewModel.Factory
    }

    private lateinit var editTextMovieName: EditText
    private lateinit var editTextHeight: EditText
    private lateinit var Button: Button

    private lateinit var binding: FragmentNewMountainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedState: Bundle?
    ): View {
        binding = FragmentNewMountainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        bindButton()
        bindEditText()
        setViewModel()
        observeStatus()

        Button.setOnClickListener{
            val name = editTextMovieName.text.toString()
            val height = editTextHeight.text.toString().toFloat()

            val newMountain = MountainModel(name, height)
           mountainViewModel.addMountain(newMountain)


            it.findNavController().navigate(R.id.action_fragment_third_to_fragment_first)
        }

    }

    private fun setViewModel(){
        binding.viewmodel = mountainViewModel
    }

    private fun observeStatus(){
        mountainViewModel.status.observe(viewLifecycleOwner) {status ->
            when{
                status.equals(MountainViewModel.WRONG_DATA) -> {
                    Log.d("APP_TAG", status)
                    mountainViewModel.clearStatus()
                }
                status.equals(MountainViewModel.MOUNTAIN_CREATED) -> {
                    Log.d("APP_TAG", status)
                    Log.d("APP_TAG", mountainViewModel.getMountain().toString())

                    mountainViewModel.clearStatus()
                    findNavController().popBackStack()
                }
            }
        }
    }

    private fun bindButton(){
        Button = view?.findViewById(R.id.button) as Button
        Button.setOnClickListener {
            it.findNavController().navigate(R.id.action_fragment_third_to_fragment_first)
        }
    }

    private fun bindEditText(){
        editTextMovieName = view?.findViewById(R.id.editTextMountainName) as EditText
        editTextHeight = view?.findViewById(R.id.editTextHeight) as EditText
    }
}