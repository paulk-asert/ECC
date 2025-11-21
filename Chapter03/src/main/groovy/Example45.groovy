/*
 * SPDX-License-Identifier: Apache-2.0
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

import util.Generation
import util.PresidentOfUSA

import static util.Generation.*

var counts = [:]

for (PresidentOfUSA president in PresidentOfUSA.ALL) {
    for (Generation gen in president.generationsServed) {
        counts.merge(gen, 1, Integer::sum)
    }
}

assert 5 == counts[GREATEST]
assert 4 == counts[SILENT]
assert 4 == counts[BOOMER]
assert 4 == counts[X]
assert 4 == counts[MILLENNIAL]
assert 3 == counts[Z]
assert 3 == counts[ALPHA]
