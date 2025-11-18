/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * Licensed under the Apache License, Version 2.0 (the "License")\n
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

var integers = 1..5
var grouped = integers.groupBy(i -> i % 2 == 0)
assert grouped == [(false): [1, 3, 5], (true): [2, 4]]

var split = integers.split(i -> i % 2 == 0)
assert split == [[2, 4], [1, 3, 5]]
