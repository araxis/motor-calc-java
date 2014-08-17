package com.arax.motorcalc.data;

import java.io.Serializable;

public class AnswerItem implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7041107636041874320L;
	public AnswerItem() {
		// TODO Auto-generated constructor stub
	}
	
	public AnswerItem(AnswerType type,String spec) {
		this.setType(type);
		this.setSpecification(spec);
	}
	
 	private AnswerType type;
 	private String specification;
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	public AnswerType getType() {
		return type;
	}
	public void setType(AnswerType type) {
		this.type = type;
	}

}
