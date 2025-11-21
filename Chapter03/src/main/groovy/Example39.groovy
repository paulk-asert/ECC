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
import org.eclipse.collections.api.factory.primitive.CharBags

var strings = Bags.mutable.with(
        'A',
        'B', 'B',
        'C', 'C', 'C',
        'D', 'D', 'D', 'D'
)

assert 'D' == strings.topOccurrences(1).first.one

char[] source = [
        'A',
        'B', 'B',
        'C', 'C', 'C',
        'D', 'D', 'D', 'D'
]
var chars = CharBags.mutable.with(*source)
char expected = 'D'
assert expected == chars.topOccurrences(1).first.one
