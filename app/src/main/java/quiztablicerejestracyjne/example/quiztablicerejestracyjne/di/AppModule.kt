package quiztablicerejestracyjne.example.quiztablicerejestracyjne.di

import android.content.Context
import androidx.room.Room
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import quiztablicerejestracyjne.example.data.local.PlateDatabase
import quiztablicerejestracyjne.example.data.local.repos.PlateRepositoryImpl
import quiztablicerejestracyjne.example.domain.repos.PlateRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    abstract fun bindsPlateRepository(plateRepositoryImpl: PlateRepositoryImpl): PlateRepository

    companion object {

        @Provides
        @Singleton
        fun provideDatabase(@ApplicationContext context: Context): PlateDatabase = Room
            .databaseBuilder(context, PlateDatabase::class.java, "PlateDb")
            .createFromAsset("databases/tablice.sql")
            .build()

        @Provides
        fun provideDatabaseDao(database: PlateDatabase) = database.dao()

    }

}