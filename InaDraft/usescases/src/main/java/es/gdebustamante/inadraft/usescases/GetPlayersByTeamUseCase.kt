package es.gdebustamante.inadraft.usescases

import es.gdebustamante.inadraft.domain.PlayerBO
import es.gdebustamante.inadraft.repository.PlayerRepository

/**
 * Caso de uso para recoger un listado de jugadores dado el id de un equipo
 */
class GetPlayersByTeamUseCase(private val playerRepository: PlayerRepository) {
    
    suspend operator fun invoke(teamId : Int): List<PlayerBO> = playerRepository.getPlayerListByTeam(teamId)
}