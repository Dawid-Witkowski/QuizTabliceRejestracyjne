package quiztablicerejestracyjne.example.domain.repos

import quiztablicerejestracyjne.example.domain.models.Plate

interface PlateRepository {
    suspend fun getAllPlates(): List<Plate>
    suspend fun getPlateWithId(id: Int): Plate?
    suspend fun getAllPlatesMatchingShortName(shortName: String): List<Plate>
}