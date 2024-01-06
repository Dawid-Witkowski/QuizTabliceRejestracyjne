package quiztablicerejestracyjne.example.data.local.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import quiztablicerejestracyjne.example.domain.models.Plate

@Entity(tableName = "Plates")
data class PlateEntity(
    @ColumnInfo(name="FullName") val fullName: String,
    @ColumnInfo(name="ShortName") val shortName: String,
    @PrimaryKey val ID: Int
) {
    fun toPlate(): Plate = Plate(id = ID, fullName = fullName, shortName = shortName)
}