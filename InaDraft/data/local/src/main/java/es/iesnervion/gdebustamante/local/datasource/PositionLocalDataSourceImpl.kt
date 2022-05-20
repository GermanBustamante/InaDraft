package es.iesnervion.gdebustamante.local.datasource

import es.gdebustamante.inadraft.domain.PositionBO
import es.gdebustamante.inadraft.position.PositionLocalDataSource

class PositionLocalDataSourceImpl: PositionLocalDataSource {
    override suspend fun getLocalPositions(): List<PositionBO> {
        return emptyList()
    }

    override suspend fun insertPositions(positons: List<PositionBO>) {

    }
}