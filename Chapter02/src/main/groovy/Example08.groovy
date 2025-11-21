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

import org.eclipse.collections.api.bag.Bag
import org.eclipse.collections.api.block.procedure.Procedure
import org.eclipse.collections.api.factory.Bags
import org.eclipse.collections.api.factory.BiMaps
import org.eclipse.collections.api.factory.Lists
import org.eclipse.collections.api.factory.Maps
import org.eclipse.collections.api.factory.Sets
import org.eclipse.collections.api.factory.SortedBags
import org.eclipse.collections.api.factory.SortedMaps
import org.eclipse.collections.api.factory.SortedSets
import org.eclipse.collections.api.factory.Stacks

iterableTest(Lists.mutable.with("One", "Two"))
iterableTest(Sets.mutable.with("One", "Two"))
iterableTest(SortedSets.mutable.with("One", "Two"))
iterableTest(Bags.mutable.with("One", "Two"))
iterableTest(SortedBags.mutable.with("One", "Two"))
iterableTest(Stacks.mutable.with("One", "Two"))
iterableTest(Maps.mutable.with(1, "One", 2, "Two"))
iterableTest(SortedMaps.mutable.with(1, "One", 2, "Two"))
iterableTest(BiMaps.mutable.with(1, "One", 2, "Two"))

iterableTest(Lists.immutable.with("One", "Two"))
iterableTest(Sets.immutable.with("One", "Two"))
iterableTest(SortedSets.immutable.with("One", "Two"))
iterableTest(Bags.immutable.with("One", "Two"))
iterableTest(SortedBags.immutable.with("One", "Two"))
iterableTest(Stacks.immutable.with("One", "Two"))
iterableTest(Maps.immutable.with(1, "One", 2, "Two"))
iterableTest(SortedMaps.immutable.with(1, "One", 2, "Two"))
iterableTest(BiMaps.immutable.with(1, "One", 2, "Two"))

void iterableTest(Iterable<String> iterable) {
    var expected = Bags.immutable.of("One", "Two")
    assert iterableForLoop(iterable) == expected
    assert iterableForEach(iterable) == expected
    assert iterableEach(iterable) == expected
}

Bag<String> iterableForLoop(Iterable<String> iterable) {
    var result = Bags.mutable.<String>empty()
    for (String each: iterable) {
        result.add(each)
    }
    result
}

Bag<String> iterableForEach(Iterable<String> iterable) {
    var result = Bags.mutable.<String>empty()
    Procedure add = result::add
    iterable.forEach(add)
    result
}

Bag<String> iterableEach(Iterable<String> iterable) {
    var result = Bags.mutable.<String>empty()
    Procedure add = result::add
    iterable.each(add)
    result
}
