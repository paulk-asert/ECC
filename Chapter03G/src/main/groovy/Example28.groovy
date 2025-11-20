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

var oneToTenByOne = 1..10
assert '12345678910' == oneToTenByOne.join()

var oneToTenByTwo = oneToTenByOne.by(2)
assert '13579' == oneToTenByTwo.join()

var oneToElevenByTwo = (1..11).by(2)
assert '1357911' == oneToElevenByTwo.join()

var tenToOneByOne = oneToTenByOne.reverse()
assert '10987654321' == tenToOneByOne.join()

tenToOneByOne = 10..1                          // alternative
assert '10987654321' == tenToOneByOne.join()

var tenToOneByNegativeTwo = tenToOneByOne.by(-2)
assert '108642' == tenToOneByNegativeTwo.join()

var evensFromOneToFive = (1<..<5).by(2)
assert '24' == evensFromOneToFive.join()

var oddsFromOneToFive = (1..5).by(2)
assert '135' == oddsFromOneToFive.join()
