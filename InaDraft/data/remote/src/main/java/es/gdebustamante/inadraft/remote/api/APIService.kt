package es.gdebustamante.inadraft.remote.api

import es.gdebustamante.inadraft.entity.dto.PlayerDTO
import es.gdebustamante.inadraft.entity.dto.PositionDTO
import es.gdebustamante.inadraft.entity.dto.TeamDTO
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Path

interface APIService {

    @GET("Teams")
    suspend fun getTeams() : Response<List<TeamDTO>>

    @GET("Players")
    suspend fun getPlayers() : Response<List<PlayerDTO>>

    @GET("Teams/{id}")
    suspend fun getTeam(@Path(value = "id") teamId : Int) : Response<TeamDTO>

    @GET("Positions")
    suspend fun getPositions() : Response<List<PositionDTO>>
}