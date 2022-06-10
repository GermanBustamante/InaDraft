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
import es.gdebustamante.inadraft.remote.DateRemoteAdapter
import es.gdebustamante.inadraft.remote.api.InaDraftApiService
import es.gdebustamante.inadraft.remote.datasource.*
import es.gdebustamante.inadraft.team.TeamRemoteDataSource
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

private const val MAX_TIME_CONNECT_TIMEOUT_RETROFIT = 30L
private const val MAX_TIME_READ_TIMEOUT_RETROFIT = 30L

/**
 * Modulo de inyección de dependencias sobre el módulo data:remote
 */
@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {

    private const val RETROFIT_PRODUCTS_API_BASE_URL = "https://inadraft.azurewebsites.net/api/"

    //region datasources

    @Provides
    fun teamRemoteDataSourceProvider(apiService: InaDraftApiService): TeamRemoteDataSource =
        TeamRemoteDataSourceImpl(apiService)

    @Provides
    fun playerRemoteDataSourceProvider(apiService: InaDraftApiService): PlayerRemoteDataSource =
        PlayerRemoteDataSourceImpl(apiService)

    @Provides
    fun positionRemoteDataSourceProvider(apiService: InaDraftApiService): PositionRemoteDataSource =
        PositionRemoteDataSourceImpl(apiService)

    @Provides
    fun formationRemoteDataSourceProvider(apiService: InaDraftApiService): FormationRemoteDataSource =
        FormationRemoteDataSourceImpl(apiService)

    @Provides
    fun gameRemoteDataSourceProvider(apiService: InaDraftApiService): GameRemoteDataSource =
        GameRemoteDataSourceImpl(apiService)

    //endregion

    //region retrofit + moshi

    @Provides
    fun httpClientProvider(): OkHttpClient =
        OkHttpClient.Builder()
            .connectTimeout(MAX_TIME_CONNECT_TIMEOUT_RETROFIT, TimeUnit.SECONDS)
            .readTimeout(MAX_TIME_READ_TIMEOUT_RETROFIT, TimeUnit.SECONDS)
            .build()

    @Provides
    fun moshiProvider(): Moshi =
        Moshi.Builder()
            .add(DateRemoteAdapter())
            .build()

    @Singleton
    @Provides
    fun retrofitProvider(moshi: Moshi, client: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(RETROFIT_PRODUCTS_API_BASE_URL)
        .client(client)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    @Singleton
    @Provides
    fun apiServiceProvider(retrofit: Retrofit): InaDraftApiService =
        retrofit.create(InaDraftApiService::class.java)

    //endregion
}