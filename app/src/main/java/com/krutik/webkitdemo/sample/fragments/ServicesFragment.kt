package com.krutik.webkitdemo.sample.fragments

import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.krutik.webkitdemo.R
import com.krutik.webkitdemo.databinding.FragmentServicesBinding
import com.krutik.webkitdemo.sample.SharedViewModel

class ServicesFragment : Fragment() {

    private var _binding: FragmentServicesBinding? = null
    private val binding get() = _binding!!
    private lateinit var sharedViewModel: SharedViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentServicesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        binding.navigateButton.setOnClickListener {
            showRouteDialog()
        }


    }

    private fun showRouteDialog() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Enter JS Route")

        val input = EditText(requireContext())
        input.inputType = InputType.TYPE_CLASS_TEXT
        builder.setView(input)

        builder.setPositiveButton("OK") { dialog, _ ->
            val route = input.text.toString()
            sharedViewModel.setRoute(route)  // Set the route in the SharedViewModel
            sharedViewModel.setIndex(2)  // Set the route in the SharedViewModel
            dialog.dismiss()
        }
        builder.setNegativeButton("Cancel") { dialog, _ -> dialog.cancel() }
        builder.show()
    }


}