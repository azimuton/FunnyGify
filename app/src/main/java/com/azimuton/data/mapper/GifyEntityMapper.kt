package com.azimuton.data.mapper

import com.azimuton.data.models.GifyEntity
import com.azimuton.domain.model.Gify

class GifyEntityMapper : MapperData<GifyEntity, Gify> {

    override fun mapFromEntity(type: GifyEntity): Gify =
        Gify(
            data = type.data,
            meta = type.meta,
            pagination = type.pagination
        )
}