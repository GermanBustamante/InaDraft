package es.sdos.formacion.monumentosandaluces.entity

import es.gdebustamante.inadraft.domain.PlayerBO
import es.gdebustamante.inadraft.domain.TeamBO
import es.gdebustamante.inadraft.entity.dto.PlayerDTO
import es.gdebustamante.inadraft.entity.dto.TeamDTO

//fun TeamBO.toDTO() = TeamDTO(
//    id,
//    name,
//    shield
//)

fun TeamDTO.toBO() = TeamBO(
    id ?: -1,
    name ?: "",
    shield ?: ""
)

fun PlayerDTO.toBO(): PlayerBO = PlayerBO(
    id ?: -1,
    name ?: "",
    position ?: "",
    kick ?: -1,
    body ?: -1,
    control ?: -1,
    guard ?: -1,
    speed ?: -1,
    stamina ?: -1,
    guts ?: -1,
    photo ?: "",
    idTeam ?: -1
)


