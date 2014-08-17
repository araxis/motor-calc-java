package com.arax.motorcalc.data;

import com.j256.ormlite.field.DatabaseField;

public class Contactor implements  IContactor {
	
	public static final String CURRENT_FIELD_NAME = "current";
	
	@DatabaseField(generatedId = true)
	private int id;
	
	@DatabaseField
	private int voltage;
	
	@DatabaseField(columnName=CURRENT_FIELD_NAME)
	private int current;

	@Override
	public int getVoltage() {
		return voltage;
	}

	public void setVoltage(int voltage) {
		this.voltage = voltage;
	}

	@Override
	public int getCurrent() {
		return current;
	}

	@Override
	public void setCurrent(int current) {
		this.current = current;
	}

	@Override
	public int getId() {
		
		return this.id;
	}

	@Override
	public void setId(int id) {
		
		this.id=id;
	}
	
	@Override
	public String toString() {
		String ret="Contactor:"+getCurrent()+" A";
		return ret;
	}

	@Override
	public String getTag() {
		return "KC:"+getCurrent()+" A";
	}

}
