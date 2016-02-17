/*
 * Copyright 2015 Mikhail Shugay
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.antigenomics.vdjdb.api

import com.antigenomics.vdjdb.db.Column
import com.antigenomics.vdjdb.impl.ClonotypeDatabase
import org.junit.Test

import static com.antigenomics.vdjdb.VDJdbAPI.*

class VDJdbApiTest {
    @Test
    void headerTest() {
        println header.collect { it.name }
        assert ['cdr3', 'antigen'].every { name -> header.any { Column col -> col.name == name } }
    }

    @Test
    void dbCreationTest() {
        assert !getDatabase().columns.empty
        assert !getDatabase().rows.empty
    }

    @Test
    void clonotypeDbTest() {
        def row = getDatabase().rows[0]
        assert !asClonotypeDatabase(getDatabase()).search(
                row[ClonotypeDatabase.V_COL_DEFAULT].value,
                row[ClonotypeDatabase.J_COL_DEFAULT].value,
                row[ClonotypeDatabase.CDR3_COL_DEFAULT].value
        ).empty
    }
}