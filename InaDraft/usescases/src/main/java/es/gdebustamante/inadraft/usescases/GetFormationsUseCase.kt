package es.gdebustamante.inadraft.usescases

import es.gdebustamante.inadraft.domain.FormationBO
import es.gdebustamante.inadraft.repository.FormationRepository

/**
 * Caso de uso para recoger un listado de alineaciones
 */
class GetFormationsUseCase(private val formationRepository: FormationRepository) {

    suspend operator fun invoke(): List<FormationBO> = formationRepository.getFormations()

}