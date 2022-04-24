package es.gdebustamante.inadraft.framework.data.entities

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TeamDTO(
    @Json(name = "id") val id: Int?,
    @Json(name = "name") val name: String?,
    @Json(name = "photo") val shield: String?
)
