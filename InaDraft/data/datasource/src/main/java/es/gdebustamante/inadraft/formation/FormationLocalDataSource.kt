package es.gdebustamante.inadraft.formation

import es.gdebustamante.inadraft.domain.FormationBO

interface FormationLocalDataSource {

    suspend fun getLocalFormations(): List<FormationBO>

    suspend fun insertLocalFormations(formations : List<FormationBO>)

}