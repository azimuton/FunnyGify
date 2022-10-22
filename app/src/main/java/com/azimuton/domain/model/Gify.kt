package com.azimuton.domain.model

import com.azimuton.data.models.DataEntity
import com.azimuton.data.models.Meta
import com.azimuton.data.models.Pagination

class Gify(
    val data: List<DataEntity>,
    val meta: Meta,
    val pagination: Pagination
        )