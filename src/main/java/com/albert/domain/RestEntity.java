/**
 * 
 */
package com.albert.domain;

/**
 * @author Administrator
 * 响应实体 RESTful
 */
public class RestEntity implements EntityBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 267755863298736996L;
	
	private String errorCode;
	
	private Integer status;
	
	private String msg;
	
	private Object object;
	
	public RestEntity() {
	}
	
	
	public RestEntity(Integer status, String msg, Object object) {
		super();
		this.status = status;
		this.msg = msg;
		this.object = object;
	}
	

	public  RestEntity(Integer status, String msg,String errorCode) {
		super();
		this.status = status;
		this.msg = msg;
		this.errorCode = errorCode;
	}
	public  RestEntity(Integer status, String msg) {
		super();
		this.status = status;
		this.msg = msg;
	}
	
	
	public static RestEntity success(Object object){
		return new RestEntity(1, "SUCCESS", object);
	}
	
	public static RestEntity failed(){
		return new RestEntity(-1, "FAILED");
	}
	public static RestEntity failed(String msg){
		return new RestEntity(-1, msg);
	}
	
	public static RestEntity failed(String msg,String errorCode){
		return new RestEntity(-1,msg,errorCode);
	}
	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}


	public String getErrorCode() {
		return errorCode;
	}


	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
}
