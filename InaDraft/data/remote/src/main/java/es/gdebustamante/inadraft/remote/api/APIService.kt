package es.gdebustamante.inadraft.remote.api

import es.gdebustamante.inadraft.entity.dto.PlayerDTO
import es.gdebustamante.inadraft.entity.dto.TeamDTO
import retrofit2.Response
import retrofit2.http.GET

interface APIService {

    @GET("Teams")
    suspend fun getTeams() : Response<List<TeamDTO>>

    @GET("Players")
    suspend fun getPlayers() : Response<List<PlayerDTO>>
}