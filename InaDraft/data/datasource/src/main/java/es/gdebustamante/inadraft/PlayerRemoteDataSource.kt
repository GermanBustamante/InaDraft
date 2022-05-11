package es.gdebustamante.inadraft

import es.gdebustamante.inadraft.domain.PlayerBO

interface PlayerRemoteDataSource {
    suspend fun getPlayerListFromTeam(teamId : Int): List<PlayerBO>
}