package com.azimuton.domain.model

data class Pagination(
    val count: Int,
    val offset: Int,
    val total_count: Int
)