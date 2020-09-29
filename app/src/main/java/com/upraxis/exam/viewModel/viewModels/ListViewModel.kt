package com.upraxis.exam.viewModel.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import com.upraxis.exam.model.models.Person
import com.upraxis.exam.viewModel.repositories.PersonRepository
import timber.log.Timber

class ListViewModel(application: Application) : AndroidViewModel(application) {

    private val personRepository = PersonRepository.getInstance(application)
    val personListLiveData: LiveData<List<Person>> = liveData(Dispatchers.IO) {
        emitSource(personRepository.getAllPersonsLiveData())
    }
}
