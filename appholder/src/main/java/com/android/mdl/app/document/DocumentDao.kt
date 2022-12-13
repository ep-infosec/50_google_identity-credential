/*
 * Copyright (C) 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/

package com.android.mdl.app.document

import androidx.room.*

@Dao
interface DocumentDao {
    @Query("SELECT * FROM document")
    suspend fun getAll(): List<Document>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(document: Document)

    @Delete
    suspend fun delete(document: Document)

    @Query("SELECT * FROM document WHERE identity_credential_name = :credentialName")
    suspend fun findById(credentialName: String): Document?
}