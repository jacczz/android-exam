package com.upraxis.exam.model.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "person_table")
data class Person(
    @Expose
    @PrimaryKey
    val id: Int,
    @SerializedName("first_name")
    @Expose
    val firstName: String,
    @SerializedName("last_name")
    @Expose
    val lastName: String,
    @SerializedName("birthday")
    @Expose
    val birthday: String,
    @SerializedName("age")
    @Expose
    val age: Int,
    @SerializedName("email_address")
    @Expose
    val emailAddress: String,
    @SerializedName("mobile_number")
    @Expose
    val mobileNumber: String,
    @SerializedName("address")
    @Expose
    val address: String,
    @SerializedName("contact_person")
    @Expose
    val contactPerson: String,
    @SerializedName("contact_person_mb")
    @Expose
    val contactPersonMb: String
)
