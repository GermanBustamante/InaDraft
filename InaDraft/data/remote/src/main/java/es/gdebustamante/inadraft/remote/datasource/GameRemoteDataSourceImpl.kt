package es.gdebustamante.inadraft.remote.datasource

import es.gdebustamante.inadraft.domain.GameBO
import es.gdebustamante.inadraft.entity.toBO
import es.gdebustamante.inadraft.entity.toDTO
import es.gdebustamante.inadraft.formation.FormationRemoteDataSource
import es.gdebustamante.inadraft.game.GameRemoteDataSource
import es.gdebustamante.inadraft.remote.api.InaDraftApiService

/**
 * Implementación de [GameRemoteDataSource] que usa una BBDD para operaciones CRUD sobre formaciones
 */
class GameRemoteDataSourceImpl(private val apiService: InaDraftApiService) : GameRemoteDataSource {

    override suspend fun getRemoteGames(): List<GameBO> =
        apiService.getGames().map { it.toBO() }

    override suspend fun insertRemoteGame(game: GameBO) : Boolean =
         apiService.insertGame(game.toDTO()).isSuccessful
}