package es.gdebustamante.inadraft.util.mapper

import es.gdebustamante.inadraft.framework.data.entities.TeamDTO
import es.gdebustamante.inadraft.domain.entities.TeamBO

fun TeamBO.toDTO() = TeamDTO(
    id,
    name,
    shield
)

fun TeamDTO.toBO() = TeamBO(
    id ?: -1,
    name ?: "",
    shield ?: ""
)