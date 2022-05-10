package es.sdos.formacion.monumentosandaluces.repository

import es.gdebustamante.inadraft.domain.TeamBO
import es.sdos.formacion.monumentosandaluces.datasource.TeamRemoteDataSource

class TeamRepository(private val remoteDataSource : TeamRemoteDataSource) {
    suspend fun getTeamList(): List<TeamBO> = remoteDataSource.getTeams()
}