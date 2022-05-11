package es.sdos.formacion.monumentosandaluces.datasource

import es.gdebustamante.inadraft.domain.TeamBO

interface TeamRemoteDataSource {
    suspend fun getTeams() : List<TeamBO>
}