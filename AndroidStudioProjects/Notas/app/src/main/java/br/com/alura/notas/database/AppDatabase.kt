package br.com.alura.notas.database

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.alura.notas.database.dao.NotaDao
import br.com.alura.notas.database.migrations.MIGRATION_1_2
import br.com.alura.notas.database.migrations.Migration_2_3
import br.com.alura.notas.database.migrations.Migration_3_4
import br.com.alura.notas.model.Nota

@Database(
    version = 4,
    entities = [Nota::class],
    exportSchema = true

)
abstract class AppDatabase : RoomDatabase() {

    abstract fun notaDao(): NotaDao

    companion object {
        @Volatile
        private var db: AppDatabase? = null

        fun instancia(context: Context): AppDatabase {
            return db ?: Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "ceep.db"
            ).addMigrations(
                MIGRATION_1_2,
                Migration_2_3,
                Migration_3_4
            ).build()
        }
    }

}