package es.gdebustamante.inadraft.framework.data.datasources

import es.gdebustamante.inadraft.data.datasources.ServerDataSource
import es.gdebustamante.inadraft.domain.TeamBO
import es.gdebustamante.inadraft.framework.data.service.TeamAPIService
import es.gdebustamante.inadraft.util.mapper.toBO

class RemoteTeamDataSource (private val teamAPIService: TeamAPIService) : ServerDataSource {

    override suspend fun getTeams(): List<TeamBO> { //TODO CUANDO META ROOM COMPROBAR SI ES CORRECTO TRAERLO Y SINO RECOGERLO DE LA BBDD
        val teamsResponse = teamAPIService.getTeams()
        return if (teamsResponse.isSuccessful) teamsResponse.body()?.map { it.toBO() } ?: emptyList() else emptyList()
    }
}