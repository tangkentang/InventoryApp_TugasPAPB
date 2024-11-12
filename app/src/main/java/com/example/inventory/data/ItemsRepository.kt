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

/**
 * Repository that provides insert, update, delete, and retrieve of [Item] from a given data source.
 */
import kotlinx.coroutines.flow.Flow

/**
 * Interface ItemsRepository menyediakan metode untuk melakukan operasi penyisipan, pembaruan,
 * penghapusan, dan pengambilan data [Item] dari sumber data yang diberikan.
 */
interface ItemsRepository {

    /**
     * Mengambil semua item dari sumber data yang diberikan sebagai aliran (stream) berupa Flow.
     * Mengembalikan data dalam bentuk Flow yang berisi daftar item dalam bentuk List<Item>.
     */
    fun getAllItemsStream(): Flow<List<Item>>

    /**
     * Mengambil satu item dari sumber data yang sesuai dengan [id] yang diberikan.
     * Mengembalikan data sebagai Flow yang berisi item atau null jika tidak ditemukan.
     */
    fun getItemStream(id: Int): Flow<Item?>

    /**
     * Menyisipkan item baru ke dalam sumber data.
     * Operasi ini dilakukan secara asynchronous menggunakan coroutine.
     */
    suspend fun insertItem(item: Item)

    /**
     * Menghapus item dari sumber data.
     * Operasi ini juga dilakukan secara asynchronous menggunakan coroutine.
     */
    suspend fun deleteItem(item: Item)

    /**
     * Memperbarui data item yang ada dalam sumber data.
     * Operasi ini dilakukan secara asynchronous menggunakan coroutine.
     */
    suspend fun updateItem(item: Item)
}

