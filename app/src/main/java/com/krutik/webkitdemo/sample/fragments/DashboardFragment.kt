package com.krutik.webkitdemo.sample.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.krutik.webkitdemo.R

class DashboardFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        println("fbhjecbhscbhchjbc")
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }
}