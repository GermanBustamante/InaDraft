package es.gdebustamante.inadraft.modules

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import es.gdebustamante.inadraft.data.datasources.ServerDataSource
import es.gdebustamante.inadraft.data.repositories.TeamRepository

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    fun teamRepositoryProvider(serverDataSource: ServerDataSource): TeamRepository =
        TeamRepository(serverDataSource)
}