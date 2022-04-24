package es.gdebustamante.inadraft.framework.data.datasources

import es.gdebustamante.inadraft.data.datasources.ServerDataSource
import es.gdebustamante.inadraft.util.mapper.toBO
import es.gdebustamante.inadraft.domain.entities.TeamBO
import es.gdebustamante.inadraft.framework.data.service.TeamAPIService
import javax.inject.Inject

class ServerTeamDataSource @Inject constructor(private val teamAPIService: TeamAPIService) : ServerDataSource {

    override suspend fun getTeams(): List<TeamBO> { //TODO CUANDO META ROOM COMPROBAR SI ES CORRECTO TRAERLO Y SINO RECOGERLO DE LA BBDD
        val teamsResponse = teamAPIService.getTeams()
        return if (teamsResponse.isSuccessful) teamsResponse.body()?.map { it.toBO() } ?: emptyList() else emptyList()
    }
}