package com.albert.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Value implements Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = 7563126013415952284L;

    private List<Object> params;

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Value)) {
            return false;
        }
        Value val = (Value) obj;
        if (this.params.equals(val.params)) {
            return true;
        }
        return false;
    }

    public Value() {
        params = new ArrayList<Object>();
    }

    public Value(int i) {
        params = new ArrayList<Object>(i);
    }

    public Value add(Object obj) {
        params.add(obj);
        return this;
    }

    public Value add(int index, Object obj) {
        params.add(index, obj);
        return this;
    }

    /**
     * @param params
     *            the params to set
     */
    public void setParams(List<Object> params) {
        this.params = params;
    }

    /**
     * @return the params
     */
    public List<Object> getParams() {
        return params;
    }

}
