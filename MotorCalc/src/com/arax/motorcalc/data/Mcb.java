package com.arax.motorcalc.data;

import com.j256.ormlite.field.DatabaseField;

public class Mcb  implements ICircuitBreacker{
	@DatabaseField(generatedId = true)
	private int id;
	
	@DatabaseField
	private int voltage;
	
	private double minCurrent;
	
	@DatabaseField(columnName="current")
	private double maxCurrent;
	
	@Override
	public double getMinCurrent() {
		return minCurrent;
	}

	@Override
	public void setMinCurrent(double current) {
		this.minCurrent = current;
	}
	
	@Override
	public double getMaxCurrent() {
		return maxCurrent;
	}

	@Override
	public void setMaxCurrent(double current) {
		this.maxCurrent = current;
	}

	@Override
	public int getVoltage() {
		return voltage;
	}

	public void setVoltage(int voltage) {
		this.voltage = voltage;
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
		String ret="MCB:"+getMaxCurrent()+" A";
		return ret;
	}
	
	@Override
	public String getTag() {
		return "QM:"+getMaxCurrent()+" A";
	}



}
