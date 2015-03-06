package com.xiaozhaohelper.project.base.util;

public class HQLConditionQuery {
	private String condition = null;
    private String name = null;
    private Object value = null;

	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
    
    public  void  add (String condition,String name ,Object value){
    	this.condition =   condition;
    	this.name = name;
    	this.value = value;
    }
 
 
}
