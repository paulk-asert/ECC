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

var map = [:].withDefault{ [] }
map['A'] << 'Apple'
map['B'] << 'Banana'
map['B'] << 'Blueberry'
map['C'] << 'Cherry'
map['C'] << 'Cantaloupe'
map.C << 'Coconut'   // shorthand property notation
assert map.A == ['Apple']
assert map.B == ['Banana', 'Blueberry']
assert map['C'] == ['Cherry', 'Cantaloupe', 'Coconut']
assert !map.get('D') // longhand okay too
