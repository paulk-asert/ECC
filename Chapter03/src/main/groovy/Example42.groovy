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

import util.PresidentOfUSA

import static util.Generation.*

var counts = PresidentOfUSA.ALL.countBy(PresidentOfUSA::getFirstGenerationServed)
assert 5 == counts.occurrencesOf(GREATEST)
assert 3 == counts.occurrencesOf(SILENT)
assert 3 == counts.occurrencesOf(BOOMER)
assert 3 == counts.occurrencesOf(X)
assert 3 == counts.occurrencesOf(MILLENNIAL)
assert 2 == counts.occurrencesOf(Z)
assert 2 == counts.occurrencesOf(ALPHA)
