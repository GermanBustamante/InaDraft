package es.iesnervion.gdebustamante.local.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import es.gdebustamante.inadraft.domain.FormationBO
import es.iesnervion.gdebustamante.local.room.dbo.entity.FormationDBO

@Dao
interface FormationDao {

    //region queries

    @Query("SELECT * FROM formations")
    suspend fun getFormations(): List<FormationDBO>
    //endregion

    //region insert

    @Insert
    suspend fun insertFormations(formations : List<FormationDBO>)

    //endregion

}