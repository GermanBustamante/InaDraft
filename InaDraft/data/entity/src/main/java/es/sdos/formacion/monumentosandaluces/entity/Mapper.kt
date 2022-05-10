package es.sdos.formacion.monumentosandaluces.entity

import es.gdebustamante.inadraft.domain.TeamBO
import es.sdos.formacion.monumentosandaluces.entity.dto.TeamDTO

fun TeamBO.toDTO() = es.sdos.formacion.monumentosandaluces.entity.dto.TeamDTO(
    id,
    name,
    shield
)

fun es.sdos.formacion.monumentosandaluces.entity.dto.TeamDTO.toBO() = TeamBO(
    id ?: -1,
    name ?: "",
    shield ?: ""
)