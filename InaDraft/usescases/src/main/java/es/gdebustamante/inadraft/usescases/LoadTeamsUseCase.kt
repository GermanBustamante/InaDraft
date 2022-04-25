package es.gdebustamante.inadraft.usescases

import es.gdebustamante.inadraft.data.repositories.TeamsRepository
import es.gdebustamante.inadraft.domain.TeamBO


class LoadTeamsUseCase (private val repository: TeamsRepository) {

    suspend operator fun invoke(): List<TeamBO> = repository.getTeamList()
}