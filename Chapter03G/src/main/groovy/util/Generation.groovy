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

package util

import groovy.transform.TupleConstructor

@TupleConstructor
enum Generation {
    UNCLASSIFIED('Unclassified', 1776..1842),
    PROGRESSIVE('Progressive Generation', 1843..1859),
    MISSIONARY('Missionary Generation', 1860..1882),
    LOST('Lost Generation', 1883..1900),
    GREATEST('Greatest Generation', 1901..1927),
    SILENT('Silent Generation', 1928..1945),
    BOOMER('Baby Boomers', 1946..1964),
    X('Generation X', 1965..1980),
    MILLENNIAL('Millennials', 1981..1996),
    Z('Generation Z', 1997..2012),
    ALPHA('Generation Alpha', 2013..2029)

    public static final List<Generation> ALL = values().toList()

    private static final Map<Integer, Generation> BY_YEAR = ALL.collectMany { gen ->
        gen.years.collect { [it, gen] }
    }.collectEntries()

    static Generation find(int year) {
        BY_YEAR[year] ?: UNCLASSIFIED
    }

    final String name
    final IntRange years

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
        PresidentOfUSA.ALL.findAll(president -> president.generationsServed.contains(this))
    }
}
