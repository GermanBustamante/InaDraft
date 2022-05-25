package es.gdebustamante.inadraft.formation

import es.gdebustamante.inadraft.domain.FormationBO

interface FormationRemoteDataSource {

    suspend fun getRemoteFormations(): List<FormationBO>

}