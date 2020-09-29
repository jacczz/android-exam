package com.upraxis.exam.view.fragments

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.upraxis.exam.R
import androidx.lifecycle.observe
import com.upraxis.exam.utils.PERSON_ID
import com.upraxis.exam.utils.PERSON_NAME
import com.upraxis.exam.view.adapters.PersonRecyclerViewAdapter
import com.upraxis.exam.viewModel.viewModels.ListViewModel
import kotlinx.android.synthetic.main.list_fragment.*
import timber.log.Timber


class ListFragment : Fragment(R.layout.list_fragment) {

    private val viewModel by viewModels<ListViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.apply {
            this.layoutManager = LinearLayoutManager(this.context)
            this.adapter = PersonRecyclerViewAdapter { per ->
                val bundle = bundleOf(PERSON_ID to per.id, PERSON_NAME to "${per.firstName}")
                findNavController().navigate(R.id.action_listFragment_to_detailFragment, bundle)
            }
            this.addItemDecoration(
                DividerItemDecoration(
                    this.context,
                    (this.layoutManager as LinearLayoutManager).orientation
                )
            )
        }

        viewModel.personListLiveData.observe(this) { personList ->
            cardViewListLoading.visibility = when {
                personList.isEmpty() -> {
                    View.VISIBLE
                }
                else -> View.GONE
            }
            (recyclerView.adapter as PersonRecyclerViewAdapter).submitList(personList)
        }
    }
}
