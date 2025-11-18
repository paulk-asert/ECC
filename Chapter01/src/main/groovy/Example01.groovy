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

var numbers = 1..10
var evens = numbers.stream()
    .filter(each -> each % 2 == 0)
    .toList()
var odds = numbers.stream()
    .filter(each -> each % 2 != 0)
    .toList()
assert evens == [2, 4, 6, 8, 10]
assert odds == [1, 3, 5, 7, 9]
