package com.upraxis.exam.view.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.upraxis.exam.R
import kotlinx.android.synthetic.main.start_fragment.*

class StartFragment : Fragment(R.layout.start_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         buttonAllPersons.setOnClickListener { findNavController().navigate(R.id.action_startFragment_to_listFragment) }
    }
}
