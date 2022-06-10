package es.gdebustamante.inadraft.usescases

import es.gdebustamante.inadraft.domain.GameBO
import es.gdebustamante.inadraft.repository.GameRepository

/**
 * Caso de uso para recoger un listado de partidas ordenador por puntuación en orden ascendente
 */
class GetBestGamesUseCase(private val gameRepository : GameRepository) {

    suspend operator fun invoke(): List<GameBO> = gameRepository.getBestGames()

}