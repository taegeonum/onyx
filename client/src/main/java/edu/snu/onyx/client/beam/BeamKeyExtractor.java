/*
 * Copyright (C) 2017 Seoul National University
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package edu.snu.onyx.client.beam;

import edu.snu.onyx.common.KeyExtractor;
import org.apache.beam.sdk.values.KV;

/**
 * Extracts the key from a KV element.
 * For non-KV elements, the elements themselves become the key.
 */
final class BeamKeyExtractor implements KeyExtractor {
  /**
   * Extracts key.
   * @param element element to get the key from.
   * @return the extracted key of the element.
   */
  public Object extractKey(final Object element) {
    if (element instanceof KV) {
      return ((KV) element).getKey();
    } else {
      return element;
    }
  }
}
