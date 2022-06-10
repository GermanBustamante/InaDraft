package es.gdebustamante.inadraft.usescases

import es.gdebustamante.inadraft.repository.PlayerRepository

/**
 * Caso de uso para recoger un jugador dado su id
 */
class GetPlayerByIdUseCase(private val playerRepository: PlayerRepository) {

    suspend operator fun invoke(playerId : Int) = playerRepository.getPlayer(playerId)

}