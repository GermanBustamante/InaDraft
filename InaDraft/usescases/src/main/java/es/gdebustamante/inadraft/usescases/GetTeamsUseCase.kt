package es.gdebustamante.inadraft.usescases

import es.gdebustamante.inadraft.domain.TeamBO
import es.gdebustamante.inadraft.repository.TeamRepository


class GetTeamsUseCase (private val repository: TeamRepository) {

    suspend operator fun invoke(): List<TeamBO> = repository.getTeams()
}