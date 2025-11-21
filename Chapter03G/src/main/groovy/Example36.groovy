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

import org.eclipse.collections.api.factory.Bags

var strings = Bags.mutable.empty()
strings << 'A'
strings << 'B'
strings << 'B'
strings << 'C'

strings.addOccurrences('C', 2)
strings << 'D'
strings.addOccurrences('D', 3)

assert 1..4 == 'ABCD'.toList().collect {strings.occurrencesOf(it) }
