/**
 * 
 */
package com.albert.utils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * @author albert
 * 请求参数封装
 */
public class RequestMap extends HashMap<String,Object> implements Map<String,Object>, Cloneable, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3992467218030905913L;
	private HttpServletRequest request;
	Map<String, Object> map = null;
	public RequestMap(HttpServletRequest request){
		this.request = request;
		Map<?, ?> params = request.getParameterMap();
		Iterator<?> it = params.entrySet().iterator();
		Map.Entry<?,?> entry;
		String name = "";
		String value = "";
		Map<String,Object> returnMap = new HashMap<String,Object>(); 
		while(it.hasNext()){
			entry = (Map.Entry<?,?>) it.next();
			name = (String) entry.getKey();
			Object valueObj = entry.getValue(); 
			if(null == valueObj){ 
				value = ""; 
			}else if(valueObj instanceof String[]){ 
				String[] values = (String[])valueObj;
				for(int i=0;i<values.length;i++){ 
					 value = values[i] ;
				}
				value = value.substring(0, value.length()); 
			}else{
				value = valueObj.toString(); 
			}
			returnMap.put(name, value); 
		}
		map = returnMap;
	}
	
	@Override
	public Object get(Object key) {
		return map.get(key);
	}
	
	@Override
	public Object put(String key, Object value) {
		return map.put(key, value);
	}
	
	/* (non-Javadoc)
	 * @see java.util.AbstractMap#toString()
	 */
	@Override
	public String toString() {
		return map.toString();
	}
	
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
}
