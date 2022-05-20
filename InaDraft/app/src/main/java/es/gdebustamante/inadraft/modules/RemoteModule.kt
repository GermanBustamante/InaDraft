package es.gdebustamante.inadraft.modules

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import es.gdebustamante.inadraft.player.PlayerRemoteDataSource
import es.gdebustamante.inadraft.position.PositionRemoteDataSource
import es.gdebustamante.inadraft.team.TeamRemoteDataSource
import es.gdebustamante.inadraft.remote.api.APIService
import es.gdebustamante.inadraft.remote.datasource.PlayerRemoteDataSourceImpl
import es.gdebustamante.inadraft.remote.datasource.PositionRemoteDataSourceImpl
import es.gdebustamante.inadraft.remote.datasource.TeamRemoteDataSourceImpl
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteModule {
    companion object {
        private const val RETROFIT_PRODUCTS_API_BASE_URL = "https://inadraft.azurewebsites.net/api/"
    }

    @Provides
    fun teamRemoteDataSourceProvider(apiService: APIService): TeamRemoteDataSource = TeamRemoteDataSourceImpl(apiService)

    @Provides
    fun playerRemoteDataSourceProvider(apiService: APIService): PlayerRemoteDataSource = PlayerRemoteDataSourceImpl(apiService)

    @Provides
    fun positionRemoteDataSourceProvider(apiService: APIService): PositionRemoteDataSource = PositionRemoteDataSourceImpl(apiService)

    @Singleton
    @Provides
    fun apiServiceProvider(retrofit: Retrofit): APIService =
        retrofit.create(APIService::class.java)

    @Singleton
    @Provides
    fun retrofitProvider(): Retrofit = Retrofit.Builder()
        .baseUrl(RETROFIT_PRODUCTS_API_BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
}