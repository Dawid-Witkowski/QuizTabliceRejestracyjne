package quiztablicerejestracyjne.example.data.local.repos

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import quiztablicerejestracyjne.example.data.local.PlateDao
import quiztablicerejestracyjne.example.domain.models.Plate
import quiztablicerejestracyjne.example.domain.repos.PlateRepository
import javax.inject.Inject

class PlateRepositoryImpl @Inject constructor(
    private val dao: PlateDao,
): PlateRepository {
    override suspend fun getAllPlates(): List<Plate> = withContext(Dispatchers.IO) {
        return@withContext dao.getAllPlates().map { it.toPlate() }
    }

    override suspend fun getPlateWithId(id: Int): Plate? = withContext(Dispatchers.IO) {
        return@withContext dao.getPlateWithId(id)?.toPlate()
    }

    override suspend fun getAllPlatesMatchingShortName(shortName: String): List<Plate> = withContext(Dispatchers.IO)  {
        return@withContext dao.getAllPlatesMatchingShortName(shortName).map { it.toPlate() }
    }
}