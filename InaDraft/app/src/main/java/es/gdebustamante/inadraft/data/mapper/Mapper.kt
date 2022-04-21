package es.gdebustamante.inadraft.data.mapper

import es.gdebustamante.inadraft.data.entities.bo.TeamBO
import es.gdebustamante.inadraft.data.entities.dto.TeamDTO

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