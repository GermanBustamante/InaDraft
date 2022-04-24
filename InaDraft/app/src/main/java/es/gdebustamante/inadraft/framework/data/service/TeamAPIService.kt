package es.gdebustamante.inadraft.framework.data.service

import es.gdebustamante.inadraft.framework.data.entities.TeamDTO
import retrofit2.Response
import retrofit2.http.GET

interface TeamAPIService  {

    @GET("Teams")
    suspend fun getTeams(): Response<List<TeamDTO>>
}