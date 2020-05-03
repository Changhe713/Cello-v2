/*
 * Copyright (C) 2017 Massachusetts Institute of Technology (MIT)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package org.cellocad.v2.common.algorithm;

import org.cellocad.v2.common.CObject;
import org.cellocad.v2.common.profile.AlgorithmProfile;

/**
 * The AlgorithmFactory class is an algorithm factory.
 *
 * @param <T> the type of Algorithm.
 *
 * @author Vincent Mirian
 *
 * @date Nov 21, 2017
 */
public abstract class AlgorithmFactory<T extends Algorithm> extends CObject {

  /**
   * Returns the {@link Algorithm} object that has the same name as the parameter {@code name}
   * within the {@link AlgorithmFactory}.
   *
   * @param name string used for searching the AlgorithmFactory.
   * @return The {@link Algorithm} instance if the {@link Algorithm} type exists within the
   *         {@link AlgorithmFactory}, otherwise null.
   */
  protected abstract T getAlgorithm(final String name);

  /**
   * Returns the Algorithm that has the same name as the parameter {@code algProfile} within the
   * AlgorithmFactory.
   *
   * @param algProfile AlgorithmProfile used for searching the AlgorithmFactory.
   * @return The {@link Algorithm} instance if the {@link Algorithm} type exists within the
   *         {@link AlgorithmFactory}, otherwise null.
   */
  public T getAlgorithm(final AlgorithmProfile algProfile) {
    T rtn = null;
    if (algProfile != null) {
      final String name = algProfile.getName();
      rtn = getAlgorithm(name);
      if (rtn != null) {
        rtn.setName(algProfile.getName());
      }
    }
    return rtn;
  }

}
