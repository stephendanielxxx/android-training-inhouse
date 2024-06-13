package app.training.androidtraininginhouse.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "lord")
data class LordDataClass(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "strength")
    val strength: Int,
    @ColumnInfo(name = "intelligence")
    val intelligence: Int
)
