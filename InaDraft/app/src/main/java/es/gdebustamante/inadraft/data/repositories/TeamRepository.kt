package es.gdebustamante.inadraft.data.repositories

import es.gdebustamante.inadraft.data.api.APIService
import es.gdebustamante.inadraft.data.entities.bo.TeamBO
import es.gdebustamante.inadraft.data.mapper.toBO

object TeamRepository {

    private val apiService = APIService.getAPIService()

    //API
    suspend fun getTeamsListAPI(): List<TeamBO> {
        val teamsCall = apiService.getTeams()
        return if (teamsCall.isSuccessful) teamsCall.body()?.map { it.toBO() }
            ?: emptyList() else emptyList()
    }
}