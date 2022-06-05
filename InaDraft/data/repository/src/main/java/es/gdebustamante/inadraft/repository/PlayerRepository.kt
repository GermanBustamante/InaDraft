package es.gdebustamante.inadraft.repository

import es.gdebustamante.inadraft.domain.PlayerBO
import es.gdebustamante.inadraft.domain.combine
import es.gdebustamante.inadraft.player.PlayerLocalDataSource
import es.gdebustamante.inadraft.player.PlayerRemoteDataSource

class PlayerRepository(
    private val playerRemoteDataSource: PlayerRemoteDataSource,
    private val playerLocalDataSource: PlayerLocalDataSource,
    private val teamRepository: TeamRepository,
    private val positionRepository: PositionRepository,
    private val formationRepository: FormationRepository,
    private val gameRepository: GameRepository,
) {

    suspend fun getPlayers(): List<PlayerBO> {
        var players = playerLocalDataSource.getLocalPlayers()
        if (players.isEmpty()) {
            formationRepository.getFormations()
            gameRepository.getBestGames()
            players = combineLists(playerRemoteDataSource.getRemotePlayers())
            playerLocalDataSource.insertPlayers(players)
        }
        return players
    }

    suspend fun getPlayerListByTeam(teamId: Int): List<PlayerBO> =
        playerLocalDataSource.getLocalPlayersFromTeam(teamId)

    suspend fun getRandomPlayersByPosition(positionId: Int): List<PlayerBO> =
        playerLocalDataSource.getRandomPlayersByPositon(positionId)

    suspend fun getPlayer(playerId: Int): PlayerBO =
        playerLocalDataSource.getLocalPlayer(playerId)

    //region private methods

    private suspend fun combineLists(
        players: List<PlayerBO>,
    ): List<PlayerBO> {
        val teams = teamRepository.getTeams()
        val positions = positionRepository.getPositions()
        return players.map {
            it.combine(teams.first { team -> team.id == it.team.id },
                positions.first { position -> position.id == it.position.id })
        }
    }

    //endregion
}