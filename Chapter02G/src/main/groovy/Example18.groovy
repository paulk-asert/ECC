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

import org.eclipse.collections.api.factory.BiMaps

var bimap = BiMaps.immutable.with(
        1, 'One', 2, 'Two', 3, 'Three'
)
assert (1..3).collect(i -> bimap.get(i)) == ['One', 'Two', 'Three']
assert (1..4).collect(i -> bimap.getOrDefault(i, 'None')) == ['One', 'Two', 'Three', 'None']

var inverse = bimap.inverse()
assert ['One', 'Two', 'Three'].collect(s ->
        inverse.get(s)) == 1..3
assert ['One', 'Two', 'Three', 'Four'].collect(s ->
        inverse.getOrDefault(s, 0)
) == [1, 2, 3, 0]
