package es.gdebustamante.inadraft.modules

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import es.sdos.formacion.monumentosandaluces.datasource.TeamRemoteDataSource
import es.sdos.formacion.monumentosandaluces.repository.TeamRepository

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun teamRepositoryProvider(teamRemoteDataSource : TeamRemoteDataSource): TeamRepository =
        TeamRepository(teamRemoteDataSource)
}