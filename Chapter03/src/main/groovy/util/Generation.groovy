package util
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

import org.eclipse.collections.api.factory.Lists
import org.eclipse.collections.api.factory.primitive.IntObjectMaps
import org.eclipse.collections.api.list.ImmutableList
import org.eclipse.collections.api.map.primitive.ImmutableIntObjectMap
import org.eclipse.collections.api.map.primitive.MutableIntObjectMap
import org.eclipse.collections.impl.list.primitive.IntInterval

// Example 29 + 31 + 34
enum Generation {
    UNCLASSIFIED("Unclassified", 1776, 1842),
    PROGRESSIVE("Progressive util.Generation", 1843, 1859),
    MISSIONARY("Missionary util.Generation", 1860, 1882),
    LOST("Lost util.Generation", 1883, 1900),
    GREATEST("Greatest util.Generation", 1901, 1927),
    SILENT("Silent util.Generation", 1928, 1945),
    BOOMER("Baby Boomers", 1946, 1964),
    X("util.Generation X", 1965, 1980),
    MILLENNIAL("Millennials", 1981, 1996),
    Z("util.Generation Z", 1997, 2012),
    ALPHA("util.Generation Alpha", 2013, 2029)

    public static final ImmutableList<Generation> ALL =
            Lists.immutable.with(values())

    private static final ImmutableIntObjectMap<Generation> BY_YEAR = groupEachByYear()

    private static ImmutableIntObjectMap<Generation> groupEachByYear() {
        // Build an ImmutableIntObjectMap of year (key) to util.Generation (value)
        // Loop over all Generations and all years for each util.Generation
        // Inject the map into each util.Generation and each year
        // Use withKeyValue to map the year to the util.Generation
        MutableIntObjectMap<Generation> map = IntObjectMaps.mutable.empty()
        ALL.injectInto(
                map, (map1, generation) ->
                generation.years().injectInto(
                        map1, (map2, year) ->
                        map2.withKeyValue(year, generation)))
                .toImmutable()
    }

    static Generation find(int year) {
        // Original (linear time scan):
        // return ArrayIterate.detectWithIfNone(util.Generation.values(), util.Generation::contains, year, UNCLASSIFIED);
        // Optimized (constant time lookup):
        BY_YEAR.getIfAbsent(year, () -> UNCLASSIFIED)
    }

    private final String name
    private final IntInterval years

    Generation(String name, int from, int to) {
        this.name = name
        years = IntInterval.fromTo(from, to)
    }

    IntInterval years() {
        years
    }

    String getName() {
        name
    }

    boolean yearsCountEquals(int years) {
        this.years.size() == years
    }

    boolean contains(int year) {
        years.contains(year)
    }

    boolean isAfter(int year) {
        years.first > year || years.contains(year + 1)
    }

    boolean isBefore(int year) {
        years.first < year || years.contains(year - 1)
    }

    Iterable<PresidentOfUSA> getPresidentsWhoServed() {
        PresidentOfUSA.ALL.select(president -> president.generationsServed.contains(this))
    }
}