package es.gdebustamante.inadraft.repository

import es.gdebustamante.inadraft.domain.PlayerBO
import es.gdebustamante.inadraft.PlayerRemoteDataSource

class PlayerRepository(private val playerRemoteDataSource : PlayerRemoteDataSource) {

    suspend fun getPlayerListByTeam(teamId : Int) : List<PlayerBO> = playerRemoteDataSource.getPlayerListFromTeam(teamId)
}