package es.gdebustamante.inadraft.usescases

import es.gdebustamante.inadraft.domain.GameBO
import es.gdebustamante.inadraft.repository.GameRepository

class GetBestGamesUseCase(private val gameRepository : GameRepository) {

    suspend operator fun invoke(): List<GameBO> = gameRepository.getBestGames()

}