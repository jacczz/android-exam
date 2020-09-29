package com.upraxis.exam.viewModel.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import com.upraxis.exam.model.models.Person
import com.upraxis.exam.viewModel.repositories.PersonRepository

class DetailViewModel(application: Application) : AndroidViewModel(application) {
    private val personRepository = PersonRepository.getInstance(application)
    fun personLiveData(id: Int): LiveData<Person?> = liveData(Dispatchers.IO) {
        emitSource(personRepository.getPersonByIdLiveData(id))
    }
}
