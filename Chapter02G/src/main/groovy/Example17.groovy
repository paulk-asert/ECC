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

var map = [:]
['Apple', 'Banana', 'Apple', 'Pear', 'Banana', 'Apple'].each{ map.merge(it, 1, Integer::sum) }
assert map == [Apple:3, Banana:2, Pear:1]
assert !map['Orange']
assert !map.Orange

map = [:].withDefault{ 0 }
['Apple', 'Banana', 'Apple', 'Pear', 'Banana', 'Apple'].each{ map.merge(it, 1, Integer::sum) }

assert ['Apple', 'Banana', 'Pear', 'Orange'].collect{ map[it] } == 3..0
