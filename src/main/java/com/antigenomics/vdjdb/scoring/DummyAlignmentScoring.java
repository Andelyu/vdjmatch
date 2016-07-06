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

package com.antigenomics.vdjdb.scoring;

import com.milaboratory.core.alignment.Alignment;

public class DummyAlignmentScoring implements AlignmentScoring {
    public static DummyAlignmentScoring INSTANCE = new DummyAlignmentScoring();

    private DummyAlignmentScoring() {

    }

    @Override
    public double computeScore(Alignment alignment) {
        return alignment.getScore();
    }

    @Override
    public double getScoreThreshold() {
        return Double.MIN_VALUE;
    }

    @Override
    public AlignmentScoring withScoreThreshold(double scoreThreshold) {
        return this;
    }

}
