package es.gdebustamante.inadraft.entity.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PlayerDTO(
    @Json(name = "id") val id: Int?,
    @Json(name = "name") val name: String?,
    @Json(name = "position") val position: String?,
    @Json(name = "kick") val kick: Int?,
    @Json(name = "body") val body: Int?,
    @Json(name = "control") val control: Int?,
    @Json(name = "guard") val guard: Int?,
    @Json(name = "speed") val speed: Int?,
    @Json(name = "stamina") val stamina: Int?,
    @Json(name = "guts") val guts: Int?,
    @Json(name = "photo") val photo: String?,
    @Json(name = "idTeam") val idTeam: Int?
)