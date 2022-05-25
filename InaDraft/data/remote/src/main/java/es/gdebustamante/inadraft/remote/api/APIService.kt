package es.gdebustamante.inadraft.remote.api

import es.gdebustamante.inadraft.entity.dto.FormationDTO
import es.gdebustamante.inadraft.entity.dto.PlayerDTO
import es.gdebustamante.inadraft.entity.dto.PositionDTO
import es.gdebustamante.inadraft.entity.dto.TeamDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface APIService {

    @GET("Players")
    suspend fun getPlayers(): Response<List<PlayerDTO>>

    @GET("Teams")
    suspend fun getTeams() : Response<List<TeamDTO>>

    @GET("Players/team/{id}")
    suspend fun getPlayersFromTeam(@Path(value = "id") teamId: Int): Response<List<PlayerDTO>>

    @GET("Teams/{id}")
    suspend fun getTeam(@Path(value = "id") teamId : Int) : Response<TeamDTO>

    @GET("Positions")
    suspend fun getPositions() : Response<List<PositionDTO>>

    @GET("Formations")
    abstract fun getFormations(): Response<List<FormationDTO>>
}