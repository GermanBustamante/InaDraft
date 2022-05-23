package es.iesnervion.gdebustamante.local.datasource

import es.gdebustamante.inadraft.domain.PositionBO
import es.gdebustamante.inadraft.position.PositionLocalDataSource
import es.iesnervion.gdebustamante.local.room.dao.PlayerDao
import es.iesnervion.gdebustamante.local.room.dao.PositionDao
import es.iesnervion.gdebustamante.local.room.toBO
import es.iesnervion.gdebustamante.local.room.toDBO

class PositionLocalDataSourceImpl(
    private val positionDao: PositionDao
): PositionLocalDataSource {
    override suspend fun getLocalPositions(): List<PositionBO> =
        positionDao.getPositions().map { it.toBO() }

    override suspend fun insertPositions(positons: List<PositionBO>) {
        positionDao.insertPositions(positons.map { it.toDBO() })
    }
}