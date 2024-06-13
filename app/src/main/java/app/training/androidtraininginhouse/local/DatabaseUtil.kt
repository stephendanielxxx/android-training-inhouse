package app.training.androidtraininginhouse.local

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

object DatabaseUtil {
    fun getDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "lord-db"
        ).build()
    }
}