package es.gdebustamante.inadraft.modules

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import es.gdebustamante.inadraft.data.repositories.TeamRepository
import es.gdebustamante.inadraft.usescases.LoadTeamsUseCase

@Module
@InstallIn(SingletonComponent::class)
class UsesCasesModule {

    @Provides
    fun loadTeamsUseCaseProvider(repository: TeamRepository) : LoadTeamsUseCase = LoadTeamsUseCase(repository)
}