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


import org.eclipse.collections.api.*
import org.eclipse.collections.api.block.predicate.Predicate
import org.eclipse.collections.api.collection.ImmutableCollection
import org.eclipse.collections.api.factory.*

var mutable = Lists.mutable.of('Covariant', 'Overrides')
assert mutable instanceof RichIterable
var immutable = mutable.toImmutable()
assert immutable instanceof ImmutableCollection
var lazyIterable = mutable.asLazy()
assert lazyIterable instanceof LazyIterable

Predicate cWords = each -> each.startsWith('C')
var expected = ['Covariant']
assert mutable.select(cWords) == expected
assert immutable.select(cWords) == expected
assert lazyIterable.select(cWords).toList() == expected
