package com.azimuton.data.mapper

interface MapperData<E, D> {

    fun mapFromEntity(type: E): D
}