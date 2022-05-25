package es.gdebustamante.inadraft.entity.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FormationDTO (
    @Json(name = "id") val id: Int?,
    @Json(name = "name") val name: String?,
    @Json(name = "preview") val photo : String?
)