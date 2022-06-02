package es.gdebustamante.inadraft.entity.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.time.LocalDate

@JsonClass(generateAdapter = true)
data class GameDTO(
    @Json(name = "id") val id: Int?,
    @Json(name = "score") val score: Int?,
    @Json(name = "date") val date: LocalDate?,
    @Json(name = "userNick") val userNick: String?,
    @Json(name = "formationId") val formationId: Int?,
)