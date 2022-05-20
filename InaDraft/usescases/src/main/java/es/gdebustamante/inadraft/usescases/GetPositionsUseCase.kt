package es.gdebustamante.inadraft.usescases

import es.gdebustamante.inadraft.repository.PositionRepository

class GetPositionsUseCase(private val positionRepository: PositionRepository) {

    suspend operator fun invoke() = positionRepository.getPositions()

}