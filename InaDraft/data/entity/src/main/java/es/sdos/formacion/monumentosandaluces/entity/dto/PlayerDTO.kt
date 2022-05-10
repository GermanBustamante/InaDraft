package es.sdos.formacion.monumentosandaluces.entity.dto

data class PlayerDTO(
    val id: Int?,
    val name: String?,
    val position: String?,
    val kick: Int?,
    val body: Int?,
    val control: Int?,
    val guard: Int?,
    val speed: Int?,
    val stamina: Int?,
    val guts: Int?,
    val photo: String?,
    val idTeam: Int?
)