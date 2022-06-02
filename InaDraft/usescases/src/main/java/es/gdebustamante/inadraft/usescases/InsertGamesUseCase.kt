package es.gdebustamante.inadraft.usescases

import es.gdebustamante.inadraft.domain.GameBO
import es.gdebustamante.inadraft.repository.GameRepository

class InsertGamesUseCase(private val gameRepository: GameRepository) {

    suspend operator fun invoke(games : List<GameBO>) = gameRepository.insertGames(games)

}