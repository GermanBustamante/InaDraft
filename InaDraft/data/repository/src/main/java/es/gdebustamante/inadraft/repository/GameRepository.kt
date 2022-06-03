package es.gdebustamante.inadraft.repository

import es.gdebustamante.inadraft.domain.GameBO
import es.gdebustamante.inadraft.domain.combineWithFormation
import es.gdebustamante.inadraft.game.GameLocalDataSource
import es.gdebustamante.inadraft.game.GameRemoteDataSource

class GameRepository(
    private val gameLocalDataSource: GameLocalDataSource,
    private val gameRemoteDataSource: GameRemoteDataSource,
    private val formationRepository: FormationRepository,
) {

    suspend fun getGames(): List<GameBO> {
        var games = gameLocalDataSource.getLocalGames()
        if (games.isEmpty()) {
            games = combineGameWithFormation(gameRemoteDataSource.getRemoteGames())
            insertGames(games)
        }
        return games
    }

    suspend fun insertGames(games: List<GameBO>) {
        gameLocalDataSource.insertLocalGames(games)
    }

    suspend fun insertGame(game: GameBO): Boolean {
        val localInserted = gameLocalDataSource.insertLocalGame(game)
        val remoteInserted = gameRemoteDataSource.insertRemoteGame(game)
        return localInserted && remoteInserted
    }

    //region private methods

    private suspend fun combineGameWithFormation(remoteGames: List<GameBO>): List<GameBO> {
        val formations = formationRepository.getFormations()
        return remoteGames.map {
            it.combineWithFormation(formations.first { formation -> it.formation.id == formation.id })
        }
    }

    //endregion

}