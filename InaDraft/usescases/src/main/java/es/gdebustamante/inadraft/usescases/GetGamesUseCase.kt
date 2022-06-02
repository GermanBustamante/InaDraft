package es.gdebustamante.inadraft.usescases

import es.gdebustamante.inadraft.domain.GameBO
import es.gdebustamante.inadraft.repository.GameRepository

class GetGamesUseCase(private val gameRepository : GameRepository) {

    suspend operator fun invoke(): List<GameBO> = gameRepository.getGames()

}