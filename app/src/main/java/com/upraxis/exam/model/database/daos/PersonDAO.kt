package com.upraxis.exam.model.database.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.upraxis.exam.model.models.Person

@Dao
interface PersonDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPerson(person: Person)

    @Delete
    fun deletePerson(person: Person)

    @Query("SELECT * FROM person_table")
    fun getAllPersonsLiveData(): LiveData<List<Person>>

    @Query("SELECT * FROM person_table WHERE id = :personId")
    fun getPersonByIdLiveData(personId: Int): LiveData<Person?>
}
