package es.gdebustamante.inadraft.usescases

import es.gdebustamante.inadraft.domain.TeamBO
import es.sdos.formacion.monumentosandaluces.repository.TeamRepository


class GetTeamListUseCase (private val repository: TeamRepository) {

    suspend operator fun invoke(): List<TeamBO> = repository.getTeamList()
}