package es.gdebustamante.inadraft.repository.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import es.gdebustamante.inadraft.player.PlayerLocalDataSource
import es.gdebustamante.inadraft.player.PlayerRemoteDataSource
import es.gdebustamante.inadraft.position.PositionLocalDataSource
import es.gdebustamante.inadraft.position.PositionRemoteDataSource
import es.gdebustamante.inadraft.repository.PlayerRepository
import es.gdebustamante.inadraft.repository.PositionRepository
import es.gdebustamante.inadraft.repository.TeamRepository
import es.gdebustamante.inadraft.team.TeamLocalDataSource
import es.gdebustamante.inadraft.team.TeamRemoteDataSource

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun teamRepositoryProvider(
        teamRemoteDataSource: TeamRemoteDataSource,
        teamLocalDataSource: TeamLocalDataSource
    ): TeamRepository =
        TeamRepository(teamRemoteDataSource, teamLocalDataSource)

    @Provides
    fun playerRepositoryProvider(
        playerRemoteDataSource: PlayerRemoteDataSource,
        playerLocalDataSource: PlayerLocalDataSource,
        teamRepository: TeamRepository,
        positionRepository: PositionRepository
    ): PlayerRepository =
        PlayerRepository(
            playerRemoteDataSource,
            playerLocalDataSource,
            teamRepository,
            positionRepository
        )

    @Provides
    fun positionRepositoryProvider(
        positionRemoteDataSource: PositionRemoteDataSource,
        positonLocalDataSource: PositionLocalDataSource
    ): PositionRepository =
        PositionRepository(positionRemoteDataSource, positonLocalDataSource)
}