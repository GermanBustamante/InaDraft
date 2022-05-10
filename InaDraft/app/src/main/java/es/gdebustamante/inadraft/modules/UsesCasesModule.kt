package es.gdebustamante.inadraft.modules

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import es.gdebustamante.inadraft.usescases.GetTeamListUseCase
import es.sdos.formacion.monumentosandaluces.repository.TeamRepository

@Module
@InstallIn(SingletonComponent::class)
class UsesCasesModule {

    @Provides
    fun loadTeamsUseCaseProvider(repository: TeamRepository) : GetTeamListUseCase = GetTeamListUseCase(repository)
}