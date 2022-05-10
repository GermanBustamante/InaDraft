package es.gdebustamante.inadraft.prueba.api

import es.sdos.formacion.monumentosandaluces.entity.dto.TeamDTO
import retrofit2.Response
import retrofit2.http.GET

interface TeamAPIService  {

    @GET("Teams")
    suspend fun getTeams(): Response<List<TeamDTO>>
}