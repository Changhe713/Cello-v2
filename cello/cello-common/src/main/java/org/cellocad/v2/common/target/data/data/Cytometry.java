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

package org.cellocad.v2.common.target.data.data;

import java.util.ArrayList;
import java.util.List;
import org.cellocad.v2.common.CObject;
import org.cellocad.v2.common.profile.ProfileUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * A representation of the collection of cytometry data for a gate in the gate assignment of the
 * <i>SimulatedAnnealing</i> algorithm.
 *
 * @author Vincent Mirian
 *
 * @date 2018-05-21
 */
public class Cytometry extends CObject {

  private void parseGateName(final JSONObject jsonObj) {
    final String value = ProfileUtils.getString(jsonObj, Cytometry.S_GATENAME);
    setGateName(value);
  }

  private void parseCytometryData(final JSONObject jsonObj) {
    final JSONArray JArr = (JSONArray) jsonObj.get(Cytometry.S_CYTOMETRYDATA);
    for (int i = 0; i < JArr.size(); i++) {
      getCytometryData().add(new CytometryData((JSONObject) JArr.get(i)));
    }
  }

  private void parseCytometry(final JSONObject jsonObj) {
    parseGateName(jsonObj);
    parseCytometryData(jsonObj);
  }

  private void init() {
    cytometryData = new ArrayList<>();
  }

  public Cytometry(final JSONObject jsonObj) {
    init();
    parseCytometry(jsonObj);
  }

  /*
   * GateName
   */
  private void setGateName(final String gateName) {
    setName(gateName);
  }

  public String getGateName() {
    return getName();
  }

  /*
   * CytometryData
   */
  private List<CytometryData> getCytometryData() {
    return cytometryData;
  }

  /**
   * Get the cytometry data at the given index.
   * 
   * @param index An index.
   * @return The cytometry data at the given index.
   */
  public CytometryData getCytometryDataAtIdx(final int index) {
    CytometryData rtn = null;
    if (0 <= index && index < getNumCytometryData()) {
      rtn = getCytometryData().get(index);
    }
    return rtn;
  }

  public int getNumCytometryData() {
    return getCytometryData().size();
  }

  private List<CytometryData> cytometryData;

  private static final String S_GATENAME = "gate_name";
  private static final String S_CYTOMETRYDATA = "cytometry_data";

}
