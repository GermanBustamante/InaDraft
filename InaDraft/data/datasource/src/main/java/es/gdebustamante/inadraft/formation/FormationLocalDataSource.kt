package es.gdebustamante.inadraft.formation

import es.gdebustamante.inadraft.domain.FormationBO

/**
 * Interfaz donde estarán los métodos para operaciones CRUD en Local sobre Formaciones
 */
interface FormationLocalDataSource {

    /**
     * Recoge un listado de formaciones de local
     */
    suspend fun getLocalFormations(): List<FormationBO>

    /**
     * Inserta un listado de formaciones en Local
     */
    suspend fun insertLocalFormations(formations : List<FormationBO>)

}