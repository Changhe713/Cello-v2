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

package org.cellocad.v2.common.profile;

import org.cellocad.v2.common.CObject;
import org.json.simple.JSONObject;

/**
 * The ProfileObject class is the base object for all profile classes within the Poros framework.
 *
 * @author Vincent Mirian
 * @date Oct 27, 2017
 */
public class ProfileObject extends CObject {

  /** Initializes a newly created {@link CObject} with an empty string as its <i>name</i>. */
  public ProfileObject() {}

  /**
   * Initializes a newly created {@link ProfileObject} using the parameter {@code jsonObj}.
   *
   * @param jsonObj The JavaScript Object Notation (JSON) representation of the {@link
   *     ProfileObject} object.
   */
  protected ProfileObject(final JSONObject jsonObj) {
    parseName(jsonObj);
  }

  /*
   * Parse
   */
  /**
   * Extracts the value of name attribute from the parameter {@code jsonObj}, and sets the name to
   * the extracted value.
   *
   * @param jsonObj The JavaScript Object Notation (JSON) representation of the {@link
   *     ProfileObject} object.
   * @throws RuntimeException if the name is not specified in the parameter {@code jsonObj}.
   */
  protected void parseName(final JSONObject jsonObj) {
    // name
    final String name = ProfileUtils.getString(jsonObj, "name");
    if (name == null) {
      throw new RuntimeException("Name not specified!");
    }
    setName(name);
  }
}
