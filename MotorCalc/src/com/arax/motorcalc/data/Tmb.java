package com.arax.motorcalc.data;

import com.j256.ormlite.field.DatabaseField;

public class Tmb  implements ICircuitBreacker{
	public static final String MAXCURRENT_FIELD_NAME = "maxCurrent"; 
	public static final String MINCURRENT_FIELD_NAME = "minCurrent"; 
	
	@DatabaseField(generatedId = true)
	private int id;
	
	@DatabaseField
	private int voltage;
	
	@DatabaseField(columnName=MAXCURRENT_FIELD_NAME)
	private double maxCurrent;
	
	@DatabaseField(columnName=MINCURRENT_FIELD_NAME)
	private double minCurrent;

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

	public double getMinCurrent() {
		return minCurrent;
	}

	public void setMinCurrent(double minCurrent) {
		this.minCurrent = minCurrent;
	}

	public double getMaxCurrent() {
		return maxCurrent;
	}

	public void setMaxCurrent(double maxCurrent) {
		this.maxCurrent = maxCurrent;
	}
	
	@Override
	public String toString() {
		String ret="TMB:"+getMinCurrent()+"-"+getMaxCurrent()+" A";
		return ret;
	}
	
	@Override
	public String getTag() {
		return "QT:"+getMinCurrent()+"-"+getMaxCurrent()+" A";
	}


}
