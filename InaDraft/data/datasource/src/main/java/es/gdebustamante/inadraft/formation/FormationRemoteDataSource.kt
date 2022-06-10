package es.gdebustamante.inadraft.formation

import es.gdebustamante.inadraft.domain.FormationBO

/**
 * Interfaz donde estarán los métodos para operaciones CRUD en Remoto sobre Formaciones
 */
interface FormationRemoteDataSource {

    /**
     * Recoge un listado de formaciones de remoto y lo devuelve
     */
    suspend fun getRemoteFormations(): List<FormationBO>

}