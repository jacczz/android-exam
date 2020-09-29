package com.upraxis.exam.viewModel.repositories

import android.app.Application
import androidx.lifecycle.LiveData
import com.upraxis.exam.api.PersonEndpoints
import com.upraxis.exam.api.RetroFitInstance
import com.upraxis.exam.model.database.UpraxisDB
import com.upraxis.exam.model.database.daos.PersonDAO
import com.upraxis.exam.model.models.Person
import timber.log.Timber

class PersonRepository private constructor(application: Application) {

    private val personDAO: PersonDAO = UpraxisDB.getDatabase(application).getPersonDao()
    private val personCalls = RetroFitInstance.getInstance().create(PersonEndpoints::class.java)

    init {
        Timber.d("${this.javaClass.name} init for the first time.")
    }

    private suspend fun insertPerson(person: Person) {
        personDAO.insertPerson(person)
    }

    private suspend fun deletePerson(person: Person) {
        personDAO.deletePerson(person)
    }

    suspend fun getAllPersonsLiveData(): LiveData<List<Person>> {
        Timber.e("getAllPersonsLiveData")
        return personDAO.getAllPersonsLiveData().also {
            getAllPersonsFromRemote()
        }
    }

    private suspend fun getAllPersonsFromRemote() {
        try {
            val personList = personCalls.getPersonList()
            personList.data.forEach {
                insertPerson(it)
            }
        } catch (exception: Throwable) {
            Timber.e(exception)
        }
    }

    suspend fun getPersonByIdLiveData(employeeId: Int): LiveData<Person?> {
        return personDAO.getPersonByIdLiveData(employeeId)
    }

    companion object {
        private var INSTANCE: PersonRepository? = null
        fun getInstance(application: Application): PersonRepository = INSTANCE ?: kotlin.run {
            INSTANCE = PersonRepository(application = application)
            INSTANCE!!
        }
    }
}
