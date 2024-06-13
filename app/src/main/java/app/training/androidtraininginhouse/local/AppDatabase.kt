package app.training.androidtraininginhouse.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [LordDataClass::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun lordDao(): LordDao
}