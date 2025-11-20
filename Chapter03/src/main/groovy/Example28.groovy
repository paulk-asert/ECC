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

import org.eclipse.collections.impl.list.Interval

var oneToTenByOne = Interval.fromToBy(1, 10, 1)
assert '12345678910' == oneToTenByOne.makeString('')

var oneToTenByTwo = oneToTenByOne.by(2)
assert '13579' == oneToTenByTwo.makeString('')

var oneToElevenByTwo = oneToTenByTwo.to(11)
assert '1357911' == oneToElevenByTwo.makeString('')

var tenToOneByOne = oneToTenByOne.reverseThis()
assert '10987654321' == tenToOneByOne.makeString('')

var tenToOneByNegativeTwo = tenToOneByOne.by(-2)
assert '108642' == tenToOneByNegativeTwo.makeString('')

var evensFromOneToFive = Interval.evensFromTo(1, 5)
assert '24' == evensFromOneToFive.makeString('')

var oddsFromOneToFive = Interval.oddsFromTo(1, 5)
assert '135' == oddsFromOneToFive.makeString('')
