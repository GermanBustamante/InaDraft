package es.gdebustamante.inadraft.repository.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import es.gdebustamante.inadraft.formation.FormationLocalDataSource
import es.gdebustamante.inadraft.formation.FormationRemoteDataSource
import es.gdebustamante.inadraft.game.GameLocalDataSource
import es.gdebustamante.inadraft.game.GameRemoteDataSource
import es.gdebustamante.inadraft.player.PlayerLocalDataSource
import es.gdebustamante.inadraft.player.PlayerRemoteDataSource
import es.gdebustamante.inadraft.position.PositionLocalDataSource
import es.gdebustamante.inadraft.position.PositionRemoteDataSource
import es.gdebustamante.inadraft.repository.*
import es.gdebustamante.inadraft.team.TeamLocalDataSource
import es.gdebustamante.inadraft.team.TeamRemoteDataSource

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun teamRepositoryProvider(
        teamRemoteDataSource: TeamRemoteDataSource,
        teamLocalDataSource: TeamLocalDataSource,
    ) =
        TeamRepository(teamRemoteDataSource, teamLocalDataSource)

    @Provides
    fun playerRepositoryProvider(
        playerRemoteDataSource: PlayerRemoteDataSource,
        playerLocalDataSource: PlayerLocalDataSource,
        teamRepository: TeamRepository,
        positionRepository: PositionRepository,
        formationRepository: FormationRepository,
        gameRepository: GameRepository
    ) =
        PlayerRepository(
            playerRemoteDataSource,
            playerLocalDataSource,
            teamRepository,
            positionRepository,
            formationRepository,
            gameRepository
        )

    @Provides
    fun positionRepositoryProvider(
        positionRemoteDataSource: PositionRemoteDataSource,
        positonLocalDataSource: PositionLocalDataSource,
    ) =
        PositionRepository(positionRemoteDataSource, positonLocalDataSource)

    @Provides
    fun formationRepositoryProvider(
        formationRemoteDataSource: FormationRemoteDataSource,
        formationLocalDataSource: FormationLocalDataSource,
    ) =
        FormationRepository(formationRemoteDataSource, formationLocalDataSource)

    @Provides
    fun gameRepositoryProvider(
        gameRemoteDataSource: GameRemoteDataSource,
        gameLocalDataSource: GameLocalDataSource,
        formationRepository: FormationRepository
    ) =
        GameRepository(gameLocalDataSource, gameRemoteDataSource, formationRepository)
}