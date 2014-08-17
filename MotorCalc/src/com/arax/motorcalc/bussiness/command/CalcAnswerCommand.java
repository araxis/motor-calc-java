package com.arax.motorcalc.bussiness.command;

import com.arax.motorcalc.data.StartMode;

public class CalcAnswerCommand {

	private double power;
	private double powerfactor;
	private double effeciency;
	private int voltage;
	private StartMode startmode;
	private boolean isbidirect;
	
	public CalcAnswerCommand(){}
	
	public CalcAnswerCommand(double power,double powerfactor,double effeciency,int voltage,StartMode startmode,boolean isbidirect) {
		this.setEffeciency(effeciency);
		this.setPower(power);;
		this.setIsbidirect(isbidirect);
		this.setVoltage(voltage);
		this.setPowerfactor(powerfactor);
		this.setStartmode(startmode);
	}

	public double getPower() {
		return power;
	}

	public void setPower(double power) {
		this.power = power;
	}

	public double getPowerfactor() {
		return powerfactor;
	}

	public void setPowerfactor(double powerfactor) {
		this.powerfactor = powerfactor;
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

	public StartMode getStartmode() {
		return startmode;
	}

	public void setStartmode(StartMode startmode) {
		this.startmode = startmode;
	}

	public boolean GetIsbidirect() {
		return isbidirect;
	}

	public void setIsbidirect(boolean isbidirect) {
		this.isbidirect = isbidirect;
	}
}
