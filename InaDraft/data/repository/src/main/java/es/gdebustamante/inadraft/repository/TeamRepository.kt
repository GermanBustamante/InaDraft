package es.gdebustamante.inadraft.repository

import es.gdebustamante.inadraft.domain.TeamBO
import es.gdebustamante.inadraft.team.TeamLocalDataSource
import es.gdebustamante.inadraft.team.TeamRemoteDataSource

class TeamRepository(private val teamRemoteDataSource : TeamRemoteDataSource, private val teamLocalDataSource: TeamLocalDataSource) {

    suspend fun getTeams(): List<TeamBO>{
        var teams = teamLocalDataSource.getLocalTeams()
        if (teams.isEmpty()){
            teams = teamRemoteDataSource.getRemoteTeams()
            teamLocalDataSource.insertLocalTeams(teams)
        }
        return teams
    }

}