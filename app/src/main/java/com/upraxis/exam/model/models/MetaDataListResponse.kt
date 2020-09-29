package com.upraxis.exam.model.models

import com.google.gson.annotations.SerializedName

data class MetaDataListResponse<T>(
    @SerializedName("status")
    val message: String?,
    @SerializedName("data")
    val data: List<T>
)
