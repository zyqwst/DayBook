/**
 * 
 */
package com.albert.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

/** 
* @ClassName: Page 
* @Description: 
* @author albert
* @date 2017年4月7日 下午12:02:22 
*  
*/
public class Page<T> extends PageRequest {
	
	public final static int MAX_SIZE = 10000000;
	public final static int MAX_PAGE = 0;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1251803627710893735L;
	/**查询到的结果*/
	private List<T> results = new ArrayList<>();
	/**查询参数，生成where 条件*/
	private RequestMap requestMap = new RequestMap(null);
	
	/**
	 * @param page
	 * @param size
	 * @param sort
	 */
	public Page(int page, int size, Sort sort) {
		super(page, size, sort);
	}
	public Page(int page, int size) {
		super(page, size, null);
	}
	public Page(int page, int size, Sort sort,RequestMap map){
		super(page, size, sort);
		this.requestMap = map;
	}
	public Page(int page, int size,RequestMap map) {
		super(page, size, null);
		this.requestMap = map;
	}
	public List<T> getResults() {
		return results;
	}
	public void setResults(List<T> results) {
		this.results = results;
	}
	public RequestMap getRequestMap() {
		return requestMap;
	}
	public void setRequestMap(RequestMap requestMap) {
		this.requestMap = requestMap;
	}
	
}
