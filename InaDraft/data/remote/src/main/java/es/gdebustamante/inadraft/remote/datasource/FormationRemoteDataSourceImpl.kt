package es.gdebustamante.inadraft.remote.datasource

import es.gdebustamante.inadraft.domain.FormationBO
import es.gdebustamante.inadraft.entity.toBO
import es.gdebustamante.inadraft.formation.FormationLocalDataSource
import es.gdebustamante.inadraft.formation.FormationRemoteDataSource
import es.gdebustamante.inadraft.remote.api.InaDraftApiService

/**
 * Implementación de [FormationRemoteDataSource] que usa una BBDD para operaciones CRUD sobre formaciones
 */
class FormationRemoteDataSourceImpl(
    private val apiService: InaDraftApiService,
) :
    FormationRemoteDataSource {

    override suspend fun getRemoteFormations(): List<FormationBO> {
        val formationsResponse = apiService.getFormations()
        return if (formationsResponse.isSuccessful) formationsResponse.body()?.map { it.toBO() }
            ?: emptyList() else emptyList()
    }

}