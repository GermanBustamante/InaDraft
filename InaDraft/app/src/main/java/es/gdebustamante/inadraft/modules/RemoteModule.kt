package es.gdebustamante.inadraft.modules

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import es.sdos.formacion.monumentosandaluces.datasource.TeamRemoteDataSource
import es.gdebustamante.inadraft.prueba.api.TeamAPIService
import es.gdebustamante.inadraft.prueba.datasource.TeamsRemoteDataSource
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteModule {
    companion object {
        private const val RETROFIT_PRODUCTS_API_BASE_URL = "https://inadraft.azurewebsites.net/api/"
    }

    @Provides// TODO si quiero dar otro dataSourceque hago
    fun serverDataSourceProvider(teamApiService: TeamAPIService): TeamRemoteDataSource = TeamsRemoteDataSource(teamApiService)

    @Singleton
    @Provides
    fun teamApiServiceProvider(retrofit: Retrofit): es.gdebustamante.inadraft.prueba.api.TeamAPIService {
        return retrofit.create(es.gdebustamante.inadraft.prueba.api.TeamAPIService::class.java)
    }

    @Singleton
    @Provides
    fun retrofitProvider(): Retrofit = Retrofit.Builder()
        .baseUrl(RETROFIT_PRODUCTS_API_BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
}