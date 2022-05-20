package es.gdebustamante.inadraft.usescases

import es.gdebustamante.inadraft.domain.PlayerBO
import es.gdebustamante.inadraft.repository.PlayerRepository

class GetPlayersByTeamUseCase(private val playerRepository: PlayerRepository) {
    
    suspend operator fun invoke(teamId : Int): List<PlayerBO> = playerRepository.getPlayerListByTeam(teamId)
}