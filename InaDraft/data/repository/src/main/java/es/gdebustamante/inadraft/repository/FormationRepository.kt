package es.gdebustamante.inadraft.repository

import es.gdebustamante.inadraft.domain.FormationBO
import es.gdebustamante.inadraft.formation.FormationLocalDataSource
import es.gdebustamante.inadraft.formation.FormationRemoteDataSource

class FormationRepository(
    private val formationRemoteDataSource: FormationRemoteDataSource,
    private val formationLocalDataSource: FormationLocalDataSource,
) {

    suspend fun getFormations(): List<FormationBO> {
        var formations = formationLocalDataSource.getLocalFormations()
        if (formations.isEmpty()) {
            formations = formationRemoteDataSource.getRemoteFormations()
            formationLocalDataSource.insertLocalFormations(formations)
        }
        return formations
    }

}