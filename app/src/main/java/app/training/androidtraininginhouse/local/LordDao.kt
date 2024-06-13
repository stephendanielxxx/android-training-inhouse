package app.training.androidtraininginhouse.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface LordDao {
    @Insert
    suspend fun insertLord(lord: LordDataClass)

    @Query(value = "SELECT * FROM lord")
    fun getLords(): Flow<List<LordDataClass>>
}