package es.gdebustamante.inadraft.modules

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import es.gdebustamante.inadraft.data.datasources.RemoteDataSource
import es.gdebustamante.inadraft.data.repositories.TeamsRepository

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    fun teamRepositoryProvider(remoteDataSource: RemoteDataSource): TeamsRepository =
        TeamsRepository(remoteDataSource)
}