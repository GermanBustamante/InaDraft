package es.gdebustamante.inadraft.usescases.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import es.gdebustamante.inadraft.repository.PlayerRepository
import es.gdebustamante.inadraft.repository.PositionRepository
import es.gdebustamante.inadraft.repository.TeamRepository
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
    fun getTeamByIdUseCaseProvider(teamRepository: TeamRepository) =
        GetTeamByIdUseCase(teamRepository)

    @Provides
    fun getPositionListUseCase(positionRepository: PositionRepository) =
        GetPositionsUseCase(positionRepository)
}