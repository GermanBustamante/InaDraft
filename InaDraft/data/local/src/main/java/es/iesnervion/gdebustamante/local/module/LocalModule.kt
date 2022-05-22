package es.iesnervion.gdebustamante.local.module

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import es.gdebustamante.inadraft.player.PlayerLocalDataSource
import es.gdebustamante.inadraft.position.PositionLocalDataSource
import es.gdebustamante.inadraft.team.TeamLocalDataSource
import es.iesnervion.gdebustamante.local.datasource.PlayerLocalDataSourceImpl
import es.iesnervion.gdebustamante.local.datasource.PositionLocalDataSourceImpl
import es.iesnervion.gdebustamante.local.datasource.TeamLocalDataSourceImpl
import es.iesnervion.gdebustamante.local.room.dao.PlayerDao
import es.iesnervion.gdebustamante.local.room.dao.PositionDao
import es.iesnervion.gdebustamante.local.room.dao.TeamDao
import es.iesnervion.gdebustamante.local.room.database.InaDraftDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    private const val INADRAFT_DATABASE_NAME = "inadraft_database"

    //region room

    @Singleton
    @Provides
    fun roomDatabaseProvider(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, InaDraftDatabase::class.java, INADRAFT_DATABASE_NAME).build()


    @Singleton
    @Provides
    fun playerDaoProvider(database: InaDraftDatabase) = database.getPlayerDao()

    @Singleton
    @Provides
    fun teamDaoProvider(database: InaDraftDatabase) = database.getTeamDao()

    @Singleton
    @Provides
    fun positionDaoProvider(database: InaDraftDatabase) = database.getPositionDao()

    //endregion

    //region datasources

    @Provides
    fun teamLocalDataSourceProvider(teamDao: TeamDao): TeamLocalDataSource = TeamLocalDataSourceImpl(teamDao)

    @Provides
    fun playerLocalDataSourceProvider(playerDao: PlayerDao): PlayerLocalDataSource = PlayerLocalDataSourceImpl(playerDao)

    @Provides
    fun positionLocalDataSourceProvider(positionDao: PositionDao): PositionLocalDataSource = PositionLocalDataSourceImpl(positionDao)

    //endregion
}