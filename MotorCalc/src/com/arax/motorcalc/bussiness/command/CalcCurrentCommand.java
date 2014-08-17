package com.arax.motorcalc.bussiness.command;

public class CalcCurrentCommand {

	private double power;
	private double powerfactor;
	private double effeciency;
	private int voltage;
	
	public CalcCurrentCommand() {
		
	}
	
public CalcCurrentCommand(double power,double powerfactor,double effeciency,int voltage) {
		this.setPower(power);
		this.setPowerfactor(powerfactor);
		this.setEffeciency(effeciency);
		this.setVoltage(voltage);
	}

public double getPowerfactor() {
	return powerfactor;
}

public void setPowerfactor(double powerfactor) {
	this.powerfactor = powerfactor;
}

public double getPower() {
	return power;
}

public void setPower(double power) {
	this.power = power;
}

public double getEffeciency() {
	return effeciency;
}

public void setEffeciency(double effeciency) {
	this.effeciency = effeciency;
}

public int getVoltage() {
	return voltage;
}

public void setVoltage(int voltage) {
	this.voltage = voltage;
}
}
