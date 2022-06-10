package es.gdebustamante.inadraft.usescases

import es.gdebustamante.inadraft.domain.PlayerBO
import es.gdebustamante.inadraft.repository.PlayerRepository

/**
 * Caso de uso para recoger un listado de jugadores aleatoria dado una posición
 */
class GetRandomPlayersByPositionUseCase(private val playerRepository: PlayerRepository) {

    suspend operator fun invoke(positionId : Int): List<PlayerBO> = playerRepository.getRandomPlayersByPosition(positionId)

}