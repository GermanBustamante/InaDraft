package es.gdebustamante.inadraft.usescases.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import es.gdebustamante.inadraft.repository.*
import es.gdebustamante.inadraft.usescases.*

@Module
@InstallIn(SingletonComponent::class)
object UsesCasesModule {

    @Provides
    fun populateDatabaseUseCaseProvider(playerRepository: PlayerRepository) =
        PopulateDatabaseUseCase(playerRepository)

    @Provides
    fun loadTeamsUseCaseProvider(teamRepository: TeamRepository): GetTeamsUseCase =
        GetTeamsUseCase(teamRepository)

    @Provides
    fun getPlayerListByTeamUseCaseProvider(playerRepository: PlayerRepository) =
        GetPlayersByTeamUseCase(playerRepository)

    @Provides
    fun getPositionListUseCaseProvider(positionRepository: PositionRepository) =
        GetPositionsUseCase(positionRepository)

    @Provides
    fun getFormationsUseCaseProvider(formationRepository: FormationRepository) =
        GetFormationsUseCase(formationRepository)

    @Provides
    fun getRandomPlayersByPositionUseCaseProvider(repository: PlayerRepository) =
        GetRandomPlayersByPositionUseCase(repository)

    @Provides
    fun getPlayerByIdUseCaseProvider(repository: PlayerRepository) =
        GetPlayerByIdUseCase(repository)

    @Provides
    fun getGamesUseCaseProvider(repository: GameRepository) =
        GetBestGamesUseCase(repository)

    @Provides
    fun insertFinishedGameUseCaseProvider(repository: GameRepository) =
        InsertFinishedGameUseCase(repository)

}