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

import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * Entity data class represents a single row in the database.
 */
// Mendeklarasikan entity "items" yang akan digunakan sebagai nama tabel di database
@Entity(tableName = "items")
data class Item(
    // Menandai 'id' sebagai primary key dengan auto-increment
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    // Menyimpan nama item
    val name: String,

    // Menyimpan harga item
    val price: Double,

    // Menyimpan jumlah item yang tersedia
    val quantity: Int
)

