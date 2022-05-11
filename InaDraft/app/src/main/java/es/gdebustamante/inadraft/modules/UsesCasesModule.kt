package es.gdebustamante.inadraft.modules

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import es.gdebustamante.inadraft.usescases.GetPlayerListByTeamUseCase
import es.gdebustamante.inadraft.usescases.GetTeamListUseCase
import es.gdebustamante.inadraft.repository.PlayerRepository
import es.gdebustamante.inadraft.repository.TeamRepository

@Module
@InstallIn(SingletonComponent::class)
class UsesCasesModule {

    @Provides
    fun loadTeamsUseCaseProvider(teamRepository: TeamRepository) : GetTeamListUseCase = GetTeamListUseCase(teamRepository)

    @Provides
    fun getPlayerListByTeamUseCaseProvider(playerRepository: PlayerRepository) : GetPlayerListByTeamUseCase = GetPlayerListByTeamUseCase((playerRepository))
}