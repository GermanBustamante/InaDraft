package es.gdebustamante.inadraft.repository

import es.gdebustamante.inadraft.domain.PositionBO
import es.gdebustamante.inadraft.position.PositionLocalDataSource
import es.gdebustamante.inadraft.position.PositionRemoteDataSource

/**
 * Repositorio que será llamado desde los casos de uso para operaciones CRUD sobre posiciones.
 * En este repositorio se trabajaran con las interfaces de los DataSources, no conociendo este las implementaciones de este y abstrayendo,
 * aplicacando inversión de dependencias y Clean Arquitechture
 */
class PositionRepository(private val positionRemoteDataSource: PositionRemoteDataSource, private val positionLocalDataSource: PositionLocalDataSource) {

    suspend fun getPositions(): List<PositionBO> {
        var positions = positionLocalDataSource.getLocalPositions()
        if (positions.isEmpty()){
            positions = positionRemoteDataSource.getRemotePositions()
            positionLocalDataSource.insertPositions(positions)
        }
        return positions
    }

}