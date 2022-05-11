package es.gdebustamante.inadraft.modules

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import es.gdebustamante.inadraft.PlayerRemoteDataSource
import es.gdebustamante.inadraft.TeamRemoteDataSource
import es.gdebustamante.inadraft.remote.api.APIService
import es.gdebustamante.inadraft.remote.datasource.PlayerRemoteDataSourceImpl
import es.gdebustamante.inadraft.remote.datasource.TeamRemoteDataSourceImpl
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteModule {
    companion object {
        private const val RETROFIT_PRODUCTS_API_BASE_URL = "http://130.61.60.150:3000/"
    }

    @Provides
    fun teamRemoteDataSourceProvider(apiService: APIService): TeamRemoteDataSource = TeamRemoteDataSourceImpl(apiService)

    @Provides
    fun playerRemoteDataSourceProvider(apiService: APIService): PlayerRemoteDataSource = PlayerRemoteDataSourceImpl(apiService)

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