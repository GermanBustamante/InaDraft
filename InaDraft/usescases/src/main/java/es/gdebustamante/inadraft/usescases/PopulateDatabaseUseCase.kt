package es.gdebustamante.inadraft.usescases

import es.gdebustamante.inadraft.repository.PlayerRepository
import es.gdebustamante.inadraft.repository.PositionRepository
import es.gdebustamante.inadraft.repository.TeamRepository

class PopulateDatabaseUseCase(private val playerRepository: PlayerRepository,private val teamRepository: TeamRepository, private val positionRepository : PositionRepository) {

    suspend operator fun invoke(){
        teamRepository.getTeams()
        playerRepository.getPlayers()
        positionRepository.getPositions()
    }


}