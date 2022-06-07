package es.gdebustamante.inadraft.team

import es.gdebustamante.inadraft.domain.TeamBO

interface TeamLocalDataSource {

    suspend fun getLocalTeams() : List<TeamBO>

    suspend fun insertLocalTeams(teams: List<TeamBO>)
}