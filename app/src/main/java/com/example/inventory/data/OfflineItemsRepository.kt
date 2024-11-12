/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.inventory.data

import kotlinx.coroutines.flow.Flow

// Kelas OfflineItemsRepository mengimplementasikan interface ItemsRepository
// dan berfungsi sebagai repository untuk mengakses data Item secara offline melalui ItemDao.
class OfflineItemsRepository(private val itemDao: ItemDao) : ItemsRepository {

    // Mengambil semua item dari database dengan menggunakan fungsi getAllItems dari itemDao.
    // Data dikembalikan dalam bentuk Flow untuk memungkinkan pemantauan perubahan data.
    override fun getAllItemsStream(): Flow<List<Item>> = itemDao.getAllItems()

    // Mengambil satu item dari database berdasarkan ID-nya dengan menggunakan fungsi getItem dari itemDao.
    // Data dikembalikan sebagai Flow yang bisa bernilai null jika item tidak ditemukan.
    override fun getItemStream(id: Int): Flow<Item?> = itemDao.getItem(id)

    // Menyisipkan item baru ke dalam database menggunakan fungsi insert dari itemDao.
    // Fungsi ini berjalan secara asynchronous dengan suspend.
    override suspend fun insertItem(item: Item) = itemDao.insert(item)

    // Menghapus item dari database menggunakan fungsi delete dari itemDao.
    // Fungsi ini juga berjalan secara asynchronous dengan suspend.
    override suspend fun deleteItem(item: Item) = itemDao.delete(item)

    // Memperbarui data item yang ada di dalam database menggunakan fungsi update dari itemDao.
    // Fungsi ini berjalan secara asynchronous dengan suspend.
    override suspend fun updateItem(item: Item) = itemDao.update(item)
}
