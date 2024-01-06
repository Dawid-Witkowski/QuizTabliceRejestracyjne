package quiztablicerejestracyjne.example.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import quiztablicerejestracyjne.example.data.local.models.PlateEntity

@Database(version = 1, entities = [PlateEntity::class])
abstract class PlateDatabase: RoomDatabase() {
    abstract fun dao(): PlateDao
}