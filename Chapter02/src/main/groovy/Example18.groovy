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
// we disabled DGM collect in the build so instead use static import
import static org.codehaus.groovy.runtime.DefaultGroovyMethods.collect

var bimap = BiMaps.immutable.with(
        1, 'One', 2, 'Two', 3, 'Three'
)
assert collect(1..3,i -> bimap.get(i)) == ['One', 'Two', 'Three']
assert collect(1..4, i ->
        bimap.getOrDefault(i, 'None')
) == ['One', 'Two', 'Three', 'None']

var inverse = bimap.inverse()
assert collect(['One', 'Two', 'Three'], s -> inverse.get(s)) == 1..3
assert collect(['One', 'Two', 'Three', 'Four'], s ->
        inverse.getOrDefault(s, 0)
) == [1, 2, 3, 0]
