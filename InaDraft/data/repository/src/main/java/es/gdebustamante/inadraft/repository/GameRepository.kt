package es.gdebustamante.inadraft.repository

import es.gdebustamante.inadraft.domain.GameBO
import es.gdebustamante.inadraft.domain.combineWithFormation
import es.gdebustamante.inadraft.game.GameLocalDataSource
import es.gdebustamante.inadraft.game.GameRemoteDataSource

/**
 * Repositorio que será llamado desde los casos de uso para operaciones CRUD sobre partidas.
 * En este repositorio se trabajaran con las interfaces de los DataSources, no conociendo este las implementaciones de este y abstrayendo,
 * aplicacando inversión de dependencias y Clean Arquitechture
 */
class GameRepository(
    private val gameLocalDataSource: GameLocalDataSource,
    private val gameRemoteDataSource: GameRemoteDataSource,
    private val formationRepository: FormationRepository,
) {

    suspend fun getBestGames(): List<GameBO> =
        combineGameWithFormation(gameRemoteDataSource.getRemoteGames())


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