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

import util.Generation

import static util.Generation.ALL

var yearsCountEquals = Generation::yearsCountEquals

assert ALL.count(yearsCountEquals.rcurry(15)) == 0

assert ALL.count(yearsCountEquals.rcurry(16)) == 3

assert ALL.count(yearsCountEquals.rcurry(17)) == 2

assert ALL.count(yearsCountEquals.rcurry(18)) == 2
