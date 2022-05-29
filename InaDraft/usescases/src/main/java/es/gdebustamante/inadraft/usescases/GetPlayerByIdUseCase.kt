package es.gdebustamante.inadraft.usescases

import es.gdebustamante.inadraft.repository.PlayerRepository

class GetPlayerByIdUseCase(private val playerRepository: PlayerRepository) {

    suspend operator fun invoke(playerId : Int) = playerRepository.getPlayer(playerId)

}