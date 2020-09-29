package com.upraxis.exam.api

import com.upraxis.exam.model.models.Person
import com.upraxis.exam.model.models.MetaDataListResponse
import retrofit2.http.GET

interface PersonEndpoints {

    @GET("v1/fa1bed93")
    suspend fun getPersonList(): MetaDataListResponse<Person>

}
