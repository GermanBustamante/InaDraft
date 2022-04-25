package es.gdebustamante.inadraft.data.repositories

import es.gdebustamante.inadraft.data.datasources.RemoteDataSource
import es.gdebustamante.inadraft.domain.TeamBO

class TeamsRepository (private val remoteDataSource: RemoteDataSource) {

    suspend fun getTeamList(): List<TeamBO> = remoteDataSource.getTeams()
}

