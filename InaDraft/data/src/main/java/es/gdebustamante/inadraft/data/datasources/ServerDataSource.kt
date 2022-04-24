package es.gdebustamante.inadraft.data.datasources

import es.gdebustamante.inadraft.domain.TeamBO

interface ServerDataSource { // Aqui de la api
    suspend fun getTeams(): List<TeamBO>
}