package com.arax.motorcalc.data;

import com.j256.ormlite.field.DatabaseField;

public class Ssd implements  IDriver{
	public static final String Power_FIELD_NAME = "power";
	@DatabaseField(generatedId = true)
	private int id;
	
	@DatabaseField
	private int voltage;
	
	@DatabaseField(columnName=Power_FIELD_NAME)
	private double power;

	@Override
	public int getVoltage() {
		return voltage;
	}

	public void setVoltage(int voltage) {
		this.voltage = voltage;
	}

	@Override
	public double getPower() {
		return power;
	}

	@Override
	public void setPower(double power) {
		this.power = power;
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
		String ret="SSD:"+getPower()+" KW";
		return ret;
	}

	@Override
	public String getTag() {
		return "SF:"+getPower()+" KW";
	}


}
