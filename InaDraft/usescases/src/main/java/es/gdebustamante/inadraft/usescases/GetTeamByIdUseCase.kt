package es.gdebustamante.inadraft.usescases

import es.gdebustamante.inadraft.domain.TeamBO
import es.gdebustamante.inadraft.repository.TeamRepository

class GetTeamByIdUseCase(private val teamRepository: TeamRepository) {

    suspend operator fun invoke(teamId : Int) : TeamBO = teamRepository.getTeam(teamId)

}