package es.gdebustamante.inadraft.modules

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import es.gdebustamante.inadraft.repository.PlayerRepository
import es.gdebustamante.inadraft.repository.PositionRepository
import es.gdebustamante.inadraft.repository.TeamRepository
import es.gdebustamante.inadraft.usescases.GetPlayerListByTeamUseCase
import es.gdebustamante.inadraft.usescases.GetPositionListUseCase
import es.gdebustamante.inadraft.usescases.GetTeamByIdUseCase
import es.gdebustamante.inadraft.usescases.GetTeamListUseCase

@Module
@InstallIn(SingletonComponent::class)
class UsesCasesModule {

    @Provides
    fun loadTeamsUseCaseProvider(teamRepository: TeamRepository): GetTeamListUseCase =
        GetTeamListUseCase(teamRepository)

    @Provides
    fun getPlayerListByTeamUseCaseProvider(playerRepository: PlayerRepository) =
        GetPlayerListByTeamUseCase(playerRepository)

    @Provides
    fun getTeamByIdUseCaseProvider(teamRepository: TeamRepository) =
        GetTeamByIdUseCase(teamRepository)

    @Provides
    fun getPositionListUseCase(positionRepository: PositionRepository) =
        GetPositionListUseCase(positionRepository)
}