package es.gdebustamante.inadraft.modules

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import es.gdebustamante.inadraft.player.PlayerLocalDataSource
import es.gdebustamante.inadraft.position.PositionLocalDataSource
import es.gdebustamante.inadraft.team.TeamLocalDataSource
import es.iesnervion.gdebustamante.local.datasource.PlayerLocalDataSourceImpl
import es.iesnervion.gdebustamante.local.datasource.PositionLocalDataSourceImpl
import es.iesnervion.gdebustamante.local.datasource.TeamLocalDataSourceImpl

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    private val INADRAFT_DATABASE_NAME = "inadraft_database"

//    @Singleton
//    @Provides
//    fun provideRoom(@ApplicationContext context: Context) =
//        Room.databaseBuilder(context, QuoteDatabase::class.java, QUOTE_DATABASE_NAME).build()

//
//    @Singleton
//    @Provides
//    fun provideQuoteDao(db: QuoteDatabase) = db.getQuoteDao()

    @Provides
    fun teamLocalDataSourceProvider(): TeamLocalDataSource = TeamLocalDataSourceImpl()

    @Provides
    fun playerLocalDataSourceProvider(): PlayerLocalDataSource = PlayerLocalDataSourceImpl()

    @Provides
    fun positionLocalDataSourceProvider(): PositionLocalDataSource = PositionLocalDataSourceImpl()

}