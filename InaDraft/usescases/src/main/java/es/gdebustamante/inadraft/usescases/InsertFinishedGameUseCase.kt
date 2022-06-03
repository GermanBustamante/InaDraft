package es.gdebustamante.inadraft.usescases

import es.gdebustamante.inadraft.domain.GameBO
import es.gdebustamante.inadraft.repository.GameRepository

class InsertFinishedGameUseCase(private val gameRepository: GameRepository) {

    suspend operator fun invoke(game : GameBO) = gameRepository.insertGame(game)

}