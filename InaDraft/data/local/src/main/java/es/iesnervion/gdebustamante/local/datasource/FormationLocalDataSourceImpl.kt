package es.iesnervion.gdebustamante.local.datasource

import es.gdebustamante.inadraft.domain.FormationBO
import es.gdebustamante.inadraft.formation.FormationLocalDataSource
import es.iesnervion.gdebustamante.local.room.dao.FormationDao
import es.iesnervion.gdebustamante.local.room.toBO
import es.iesnervion.gdebustamante.local.room.toDBO

class FormationLocalDataSourceImpl(
    private val formationDao: FormationDao
): FormationLocalDataSource {

    override suspend fun getLocalFormations(): List<FormationBO> =
        formationDao.getFormations().map { it.toBO() }

    override suspend fun insertLocalFormations(formations: List<FormationBO>) {
        formationDao.insertFormations(formations.map { it.toDBO() })
    }

}