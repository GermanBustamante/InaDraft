package es.gdebustamante.inadraft.position

import es.gdebustamante.inadraft.domain.PositionBO

/**
 * Interfaz donde estarán los métodos para operaciones CRUD en Remoto sobre Posiciones
 */
interface PositionRemoteDataSource {

    /**
     * Recoge un listado de posiciones de Remoto y las devuelve
     */
    suspend fun getRemotePositions(): List<PositionBO>
}