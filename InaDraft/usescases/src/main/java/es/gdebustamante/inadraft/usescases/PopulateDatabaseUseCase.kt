package es.gdebustamante.inadraft.usescases

import es.gdebustamante.inadraft.repository.PlayerRepository
import es.gdebustamante.inadraft.repository.PositionRepository
import es.gdebustamante.inadraft.repository.TeamRepository

/**
 * Caso de uso para poblar la base de datos
 */
class PopulateDatabaseUseCase(private val playerRepository: PlayerRepository) {

    suspend operator fun invoke(){
        playerRepository.getPlayers()
    }


}