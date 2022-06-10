package es.gdebustamante.inadraft.repository

import es.gdebustamante.inadraft.domain.FormationBO
import es.gdebustamante.inadraft.formation.FormationLocalDataSource
import es.gdebustamante.inadraft.formation.FormationRemoteDataSource

/**
 * Repositorio que será llamado desde los casos de uso para operaciones CRUD sobre formaciones.
 * En este repositorio se trabajaran con las interfaces de los DataSources, no conociendo este las implementaciones de este y abstrayendo,
 * aplicacando inversión de dependencias y Clean Arquitechture
 */
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