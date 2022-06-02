package es.gdebustamante.inadraft.remote.di

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import es.gdebustamante.inadraft.formation.FormationRemoteDataSource
import es.gdebustamante.inadraft.game.GameRemoteDataSource
import es.gdebustamante.inadraft.player.PlayerRemoteDataSource
import es.gdebustamante.inadraft.position.PositionRemoteDataSource
import es.gdebustamante.inadraft.remote.api.APIService
import es.gdebustamante.inadraft.remote.datasource.*
import es.gdebustamante.inadraft.team.TeamRemoteDataSource
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {

    private const val RETROFIT_PRODUCTS_API_BASE_URL = "https://inadraft.azurewebsites.net/api/"

    //region datasources

    @Provides
    fun teamRemoteDataSourceProvider(apiService: APIService): TeamRemoteDataSource =
        TeamRemoteDataSourceImpl(apiService)

    @Provides
    fun playerRemoteDataSourceProvider(apiService: APIService): PlayerRemoteDataSource =
        PlayerRemoteDataSourceImpl(apiService)

    @Provides
    fun positionRemoteDataSourceProvider(apiService: APIService): PositionRemoteDataSource =
        PositionRemoteDataSourceImpl(apiService)

    @Provides
    fun formationRemoteDataSourceProvider(apiService: APIService): FormationRemoteDataSource =
        FormationRemoteDataSourceImpl(apiService)

    @Provides
    fun gameRemoteDataSourceProvider(apiService: APIService): GameRemoteDataSource =
        GameRemoteDataSourceImpl(apiService)

    //endregion

    //region retrofit + moshi

    @Provides
    fun moshiProvider(): Moshi =
        Moshi.Builder()
            .add(DateAdapter())
            .build()

    @Singleton
    @Provides
    fun retrofitProvider(moshi: Moshi): Retrofit = Retrofit.Builder()
        .baseUrl(RETROFIT_PRODUCTS_API_BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    @Singleton
    @Provides
    fun apiServiceProvider(retrofit: Retrofit): APIService =
        retrofit.create(APIService::class.java)

    //endregion
}