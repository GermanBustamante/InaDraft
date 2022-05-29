package es.gdebustamante.inadraft.usescases

import es.gdebustamante.inadraft.domain.PlayerBO
import es.gdebustamante.inadraft.repository.PlayerRepository

class GetRandomPlayersByPositionUseCase(private val playerRepository: PlayerRepository) {

    suspend operator fun invoke(positionId : Int): List<PlayerBO> = playerRepository.getRandomPlayersByPosition(positionId)

}