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

var strings = [
        'A',
        'B', 'B',
        'C', 'C', 'C',
        'D', 'D', 'D', 'D'
]

var count = strings.countBy()

var top = count.sort{ e -> -e.value }
assert 'D' == top.keySet()[0]
// Example 40
assert 'A' == top.keySet()[-1]
