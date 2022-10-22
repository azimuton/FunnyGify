package com.azimuton.data.mapper

import com.azimuton.data.models.DataEntity
import com.azimuton.domain.model.Data

class ListDataMapper : MapperData<List<DataEntity>, List<Data>> {

    override fun mapFromEntity(type: List<DataEntity>): List<Data> {
        val listData = ArrayList<Data>()

        type.forEach { resultEntity ->
            listData.add(
                Data(
                    analytics = resultEntity.analytics,
                    analytics_response_payload = resultEntity.analytics_response_payload,
                    bitly_gif_url = resultEntity.bitly_gif_url,
                    bitly_url = resultEntity.bitly_url,
                    content_url = resultEntity.content_url,
                    embed_url = resultEntity.embed_url,
                    id = resultEntity.id,
                    images = resultEntity.images,
                    import_datetime = resultEntity.import_datetime,
                    is_sticker = resultEntity.is_sticker,
                    rating = resultEntity.rating,
                    slug = resultEntity.slug,
                    source = resultEntity.source,
                    source_post_url = resultEntity.source_post_url,
                    source_tld = resultEntity.source_tld,
                    title = resultEntity.title,
                    trending_datetime = resultEntity.trending_datetime,
                    type = resultEntity.type,
                    url = resultEntity.url,
                    user = resultEntity.user,
                    username = resultEntity.username
                )
            )
        }

        return listData.toList()
    }
}