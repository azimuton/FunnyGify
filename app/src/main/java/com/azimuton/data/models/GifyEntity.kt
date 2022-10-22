package com.azimuton.data.models

data class GifyEntity(
    val data: List<DataEntity>,
    val meta: Meta,
    val pagination: Pagination
)