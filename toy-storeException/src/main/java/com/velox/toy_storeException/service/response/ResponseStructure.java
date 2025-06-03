package com.velox.toy_storeException.service.response;

public class ResponseStructure<T>{
	
	private String name;
	private int status;
	private Object obj;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	
	

}
