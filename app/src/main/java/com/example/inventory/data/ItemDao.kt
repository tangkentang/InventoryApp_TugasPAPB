package com.example.inventory.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

// Mendefinisikan interface ItemDao sebagai Data Access Object (DAO) untuk entity Item
@Dao
interface ItemDao {

    // Menyisipkan item baru ke dalam tabel "items".
    // Jika ada konflik (item dengan ID yang sama sudah ada), maka akan diabaikan.
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: Item)

    // Memperbarui data item yang ada di dalam tabel "items".
    @Update
    suspend fun update(item: Item)

    // Menghapus item dari tabel "items".
    @Delete
    suspend fun delete(item: Item)

    // Mendapatkan item tertentu berdasarkan ID-nya.
    // Data dikembalikan sebagai Flow untuk memungkinkan pemantauan perubahan data.
    @Query("SELECT * from items WHERE id = :id")
    fun getItem(id: Int): Flow<Item>

    // Mendapatkan semua item yang ada di tabel "items" dan mengurutkannya berdasarkan nama secara ascending.
    // Data dikembalikan sebagai Flow agar dapat terus dipantau saat ada perubahan data.
    @Query("SELECT * from items ORDER BY name ASC")
    fun getAllItems(): Flow<List<Item>>

}




