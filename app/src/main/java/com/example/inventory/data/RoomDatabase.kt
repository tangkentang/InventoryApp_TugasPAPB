package com.example.inventory.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Database class with a singleton Instance object.
 */
// Menandai InventoryDatabase sebagai kelas database Room yang mencakup entity Item.
// Versi database ditetapkan sebagai 1, dan exportSchema diatur ke false.
@Database(entities = [Item::class], version = 1, exportSchema = false)
abstract class InventoryDatabase : RoomDatabase() {

    // Mendeklarasikan fungsi abstrak itemDao untuk mengakses DAO dari entity Item.
    abstract fun itemDao(): ItemDao

    companion object {
        // Instance singleton dari InventoryDatabase untuk mencegah pembuatan beberapa instance database.
        @Volatile
        private var Instance: InventoryDatabase? = null

        // Fungsi untuk mendapatkan instance database. Jika instance sudah ada, maka instance tersebut dikembalikan.
        // Jika tidak ada, maka akan dibuat instance database baru secara synchronized.
        fun getDatabase(context: Context): InventoryDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    InventoryDatabase::class.java,
                    "item_database" // Menentukan nama database
                ).build().also { Instance = it } // Mengatur instance yang baru dibuat ke Instance
            }
        }
    }
}