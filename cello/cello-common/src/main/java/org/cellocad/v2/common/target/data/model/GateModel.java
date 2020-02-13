/**
 * Copyright (C) 2020 Boston University (BU)
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:

 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.

 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package org.cellocad.v2.common.target.data.model;

import org.json.simple.JSONObject;

/**
 *
 *
 * @author Timothy Jones
 *
 * @date 2020-02-11
 *
 */
public class GateModel extends Model {
	
	private void init() {
	}

	private void parseGateModel(final JSONObject jObj) {
		this.init();
	}

	public GateModel(final JSONObject jObj) {
		super(jObj);
		this.parseGateModel(jObj);
	}

	@Override
	public boolean isValid() {
		boolean rtn = super.isValid();
		rtn = rtn && (this.getResponseFunction() != null);
		return rtn;
	}

	/*
	 * ResponseFunction
	 */

	/**
	 * Getter for <i>responseFunction</i>.
	 *
	 * @return value of responseFunction
	 */
	public Function getResponseFunction() {
		return responseFunction;
	}

	/**
	 * Setter for <i>responseFunction</i>.
	 *
	 * @param responseFunction the responseFunction to set
	 */
	public void setResponseFunction(final Function responseFunction) {
		this.responseFunction = responseFunction;
	}

	private Function responseFunction;

	public static final String S_RESPONSEFUNCTION = "response_function";

}
