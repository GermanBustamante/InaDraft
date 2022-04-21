package es.gdebustamante.inadraft.data.api

import es.gdebustamante.inadraft.data.entities.dto.TeamDTO
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface APIService {

    @GET("Teams")
    suspend fun getTeams(): Response<List<TeamDTO>>

    companion object {
        private const val RETROFIT_PRODUCTS_API_BASE_URL = "http://localhost:26437/api/"

        fun getAPIService(): APIService =
            getRetrofit().create(APIService::class.java)

        private fun getRetrofit(): Retrofit =
            Retrofit.Builder()
                .baseUrl(RETROFIT_PRODUCTS_API_BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
    }
}