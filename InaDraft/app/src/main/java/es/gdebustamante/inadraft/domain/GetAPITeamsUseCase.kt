package es.gdebustamante.inadraft.domain

import es.gdebustamante.inadraft.data.entities.bo.TeamBO
import es.gdebustamante.inadraft.data.repositories.TeamRepository

class GetAPITeamsUseCase {

    private val repository = TeamRepository

    suspend operator fun invoke(): List<TeamBO> = repository.getTeamsListAPI()
}