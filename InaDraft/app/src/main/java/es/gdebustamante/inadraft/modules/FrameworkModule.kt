package es.gdebustamante.inadraft.modules

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import es.gdebustamante.inadraft.framework.data.service.TeamAPIService
import es.gdebustamante.inadraft.data.datasources.ServerDataSource
import es.gdebustamante.inadraft.framework.data.datasources.RemoteTeamDataSource
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FrameworkModule {
    companion object {
        private const val RETROFIT_PRODUCTS_API_BASE_URL = "https://inadraft.azurewebsites.net/api/"
    }

    @Provides// TODO si quiero dar otro dataSourceque hago
    fun serverDataSourceProvider(teamApiService: TeamAPIService): ServerDataSource = RemoteTeamDataSource(teamApiService)

    @Singleton
    @Provides
    fun teamApiServiceProvider(retrofit: Retrofit): TeamAPIService {
        return retrofit.create(TeamAPIService::class.java)
    }

    @Singleton
    @Provides
    fun retrofitProvider(): Retrofit = Retrofit.Builder()
        .baseUrl(RETROFIT_PRODUCTS_API_BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
}