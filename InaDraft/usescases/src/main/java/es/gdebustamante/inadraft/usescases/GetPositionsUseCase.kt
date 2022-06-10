package es.gdebustamante.inadraft.usescases

import es.gdebustamante.inadraft.repository.PositionRepository

/**
 * Caso de uso para recoger un listado de posiciones
 */
class GetPositionsUseCase(private val positionRepository: PositionRepository) {

    suspend operator fun invoke() = positionRepository.getPositions()

}