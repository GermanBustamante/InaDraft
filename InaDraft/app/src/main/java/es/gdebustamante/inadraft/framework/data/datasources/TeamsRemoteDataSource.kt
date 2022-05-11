package es.gdebustamante.inadraft.framework.data.datasources

import es.gdebustamante.inadraft.domain.TeamBO
import es.gdebustamante.inadraft.prueba.api.TeamAPIService
import es.sdos.formacion.monumentosandaluces.datasource.TeamRemoteDataSource
import es.sdos.formacion.monumentosandaluces.entity.toBO

class TeamsRemoteDataSource (private val teamAPIService: TeamAPIService) : TeamRemoteDataSource {

    override suspend fun getTeams(): List<TeamBO> { //TODO CUANDO META ROOM COMPROBAR SI ES CORRECTO TRAERLO Y SINO RECOGERLO DE LA BBDD
        val teamsResponse = teamAPIService.getTeams()
        return if (teamsResponse.isSuccessful) teamsResponse.body()?.map { it.toBO() } ?: emptyList() else emptyList()
    }
}