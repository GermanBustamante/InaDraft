package es.gdebustamante.inadraft.usescases

import es.gdebustamante.inadraft.repository.PositionRepository

class GetPositionListUseCase(private val positionRepository: PositionRepository) {

    suspend operator fun invoke() = positionRepository.getPositionList()

}