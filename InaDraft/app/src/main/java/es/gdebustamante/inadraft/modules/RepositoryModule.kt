package es.gdebustamante.inadraft.modules

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import es.gdebustamante.inadraft.PlayerRemoteDataSource
import es.gdebustamante.inadraft.PositionRemoteDataSource
import es.gdebustamante.inadraft.TeamRemoteDataSource
import es.gdebustamante.inadraft.repository.PlayerRepository
import es.gdebustamante.inadraft.repository.PositionRepository
import es.gdebustamante.inadraft.repository.TeamRepository

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun teamRepositoryProvider(teamRemoteDataSource : TeamRemoteDataSource): TeamRepository =
        TeamRepository(teamRemoteDataSource)

    @Provides
    fun playerRepositoryProvider(playerRemoteDataSource: PlayerRemoteDataSource): PlayerRepository =
        PlayerRepository(playerRemoteDataSource)

    @Provides
    fun positionRepositoryProvider(positionRemoteDataSource: PositionRemoteDataSource): PositionRepository =
        PositionRepository(positionRemoteDataSource)
}