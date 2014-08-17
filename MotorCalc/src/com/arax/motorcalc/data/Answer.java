package com.arax.motorcalc.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Answer implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8810907813362410400L;
	private List<AnswerItem> items;
	private int typeResurceId;
	
	public Answer(){
		
		this.setItems(new ArrayList<AnswerItem>());
		
	}

	public List<AnswerItem> getItems() {
		return items;
	}

	public void setItems(List<AnswerItem> items) {
		this.items = items;
	}

	public int getTypeResurceId() {
		return typeResurceId;
	}

	public void setTypeResurceId(int typeResurceId) {
		this.typeResurceId = typeResurceId;
	}
	

}
