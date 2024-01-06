package quiztablicerejestracyjne.example.data.local

import androidx.room.Dao
import androidx.room.Query
import quiztablicerejestracyjne.example.data.local.models.PlateEntity

@Dao
interface PlateDao {
    @Query("SELECT * FROM plates")
    fun getAllPlates(): List<PlateEntity>

    @Query("SELECT * FROM plates WHERE ID = :id")
    fun getPlateWithId(id: Int): PlateEntity?

    @Query("SELECT * FROM plates WHERE shortName = :shortName")
    fun getAllPlatesMatchingShortName(shortName: String): List<PlateEntity>
}