package es.gdebustamante.inadraft.data.repositories

import es.gdebustamante.inadraft.data.datasources.ServerDataSource
import es.gdebustamante.inadraft.domain.entities.TeamBO
import javax.inject.Inject

class TeamRepository @Inject constructor(private val serverDataSource: ServerDataSource) {

    suspend fun getTeamList(): List<TeamBO> = serverDataSource.getTeams()
}

