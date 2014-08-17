package com.arax.motorcalc.bussiness.command;

public class CalcStartModeCommand {

	private double power;
	
	public CalcStartModeCommand() {
		
	}
	
	public CalcStartModeCommand(double power) {
		this.setPower(power);
	}

	public double getPower() {
		return power;
	}

	public void setPower(double power) {
		this.power = power;
	}
	
}
