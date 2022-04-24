package es.gdebustamante.inadraft.data.repositories

import es.gdebustamante.inadraft.data.datasources.ServerDataSource
import es.gdebustamante.inadraft.domain.TeamBO

class TeamRepository (private val serverDataSource: ServerDataSource) {

    suspend fun getTeamList(): List<TeamBO> = serverDataSource.getTeams()
}

