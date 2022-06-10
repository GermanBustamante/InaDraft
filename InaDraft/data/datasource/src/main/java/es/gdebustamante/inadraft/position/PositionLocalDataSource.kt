package es.gdebustamante.inadraft.position

import es.gdebustamante.inadraft.domain.PositionBO

/**
 * Interfaz donde estarán los métodos para operaciones CRUD en Local sobre Posiciones
 */
interface PositionLocalDataSource {

    /**
     * Recoge un listado de posiciones de Local
     */
    suspend fun getLocalPositions(): List<PositionBO>

    /**
     * Guarda un listado de posiciones en Local
     */
    suspend fun insertPositions(positons: List<PositionBO>)
}