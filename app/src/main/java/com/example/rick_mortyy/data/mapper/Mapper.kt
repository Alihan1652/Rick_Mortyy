package com.example.rick_mortyy.data.mapper

import com.example.rick_mortyy.data.models.CharacterDto
import com.example.rick_mortyy.data.models.LocationDto
import com.example.rick_mortyy.data.models.OriginDto
import com.example.rick_mortyy.domain.models.Character
import com.example.rick_mortyy.domain.models.Location
import com.example.rick_mortyy.domain.models.Origin

fun CharacterDto?.toDomain(): Character {
    return Character(
        created = this?.created.orEmpty(),
        episode = this?.episode?: emptyList(),
        gender = this?.gender.orEmpty(),
        id = this?.id ?: 0,
        image = this?.image.orEmpty(),
        location = this?.location.toDomain(),
        name = this?.name.orEmpty(),
        origin = this?.origin.toDomain(),
        species = this?.species.orEmpty(),
        status = this?.status.orEmpty(),
        type = this?.type.orEmpty(),
        url = this?.url.orEmpty()
    )
}

fun List<CharacterDto>?.toDomain(): List<Character> {
    return this?.map {characterDto ->
        characterDto.toDomain()
    } ?: emptyList()
}
fun LocationDto?.toDomain(): Location {
    return Location(
        name = this?.name.orEmpty(),
        url = this?.url.orEmpty()
    )
}

fun OriginDto?.toDomain(): Origin {
    return Origin(
        name = this?.name.orEmpty(),
        url = this?.url.orEmpty()
    )
}