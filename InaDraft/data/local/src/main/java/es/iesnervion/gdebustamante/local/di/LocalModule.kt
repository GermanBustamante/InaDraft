package es.iesnervion.gdebustamante.local.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import es.gdebustamante.inadraft.formation.FormationLocalDataSource
import es.gdebustamante.inadraft.game.GameLocalDataSource
import es.gdebustamante.inadraft.player.PlayerLocalDataSource
import es.gdebustamante.inadraft.position.PositionLocalDataSource
import es.gdebustamante.inadraft.team.TeamLocalDataSource
import es.iesnervion.gdebustamante.local.datasource.*
import es.iesnervion.gdebustamante.local.room.dao.*
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
        Room.databaseBuilder(context, InaDraftDatabase::class.java, INADRAFT_DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()


    @Singleton
    @Provides
    fun playerDaoProvider(database: InaDraftDatabase) = database.getPlayerDao()
    @Singleton
    @Provides
    fun teamDaoProvider(database: InaDraftDatabase) = database.getTeamDao()

    @Singleton
    @Provides
    fun positionDaoProvider(database: InaDraftDatabase) = database.getPositionDao()

    @Singleton
    @Provides
    fun formationDaoProvider(database: InaDraftDatabase) = database.getFormationDao()

    @Singleton
    @Provides
    fun gameDaoProvider(database: InaDraftDatabase) = database.getGameDao()

    //endregion

    //region datasources

    @Provides
    fun teamLocalDataSourceProvider(teamDao: TeamDao): TeamLocalDataSource = TeamLocalDataSourceImpl(teamDao)

    @Provides
    fun playerLocalDataSourceProvider(playerDao: PlayerDao): PlayerLocalDataSource = PlayerLocalDataSourceImpl(playerDao)

    @Provides
    fun positionLocalDataSourceProvider(positionDao: PositionDao): PositionLocalDataSource = PositionLocalDataSourceImpl(positionDao)

    @Provides
    fun formationLocalDataSourceProvider(formationDao: FormationDao): FormationLocalDataSource = FormationLocalDataSourceImpl(formationDao)

    @Provides
    fun gameLocalDataSourceProvider(gameDao: GameDao): GameLocalDataSource = GameLocalDataSourceImpl(gameDao)

    //endregion
}