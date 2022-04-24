package es.gdebustamante.inadraft.usescases

import es.gdebustamante.inadraft.data.repositories.TeamRepository
import es.gdebustamante.inadraft.domain.TeamBO

class LoadTeamListUseCase @Inject constructor(private val repository: TeamRepository) {

    suspend operator fun invoke(): List<TeamBO> = repository.getTeamList()
}