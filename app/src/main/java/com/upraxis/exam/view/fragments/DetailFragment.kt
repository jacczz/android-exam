package com.upraxis.exam.view.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.upraxis.exam.R
import com.upraxis.exam.utils.PERSON_ID
import kotlinx.android.synthetic.main.detail_fragment.*
import com.upraxis.exam.viewModel.viewModels.DetailViewModel
import kotlinx.android.synthetic.main.detail_fragment.view.*

class DetailFragment : Fragment(R.layout.detail_fragment) {

    private val viewModel by viewModels<DetailViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let { bundle ->
            viewModel.personLiveData(bundle.getInt(PERSON_ID)).observe(this) { personOrNull ->
                personOrNull?.let { person ->
                    textViewName.textViewName.text = "${person.firstName} ${person.lastName}"
                    textViewBirthday.text = person.birthday
                    textViewAge.text = "${person.age} y/old"
                    textViewEmailAdd.text = person.emailAddress
                    textViewMobileNumber.text = person.mobileNumber
                    textViewAddress.text = person.address
                    textViewContactPerson.text = person.contactPerson
                    textViewContactPersonMb.text = person.contactPersonMb
                }
            }
        }
    }
}
