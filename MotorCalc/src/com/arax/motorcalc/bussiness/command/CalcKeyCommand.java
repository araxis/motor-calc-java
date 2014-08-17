package com.arax.motorcalc.bussiness.command;

public class CalcKeyCommand {

	private double current;
	
	public CalcKeyCommand() {
		
	}
	
	public CalcKeyCommand(double current) {
	   
		this.setCurrent(current);
		
	}
	

	public double getCurrent() {
		return current;
	}

	public void setCurrent(double current) {
		this.current = current;
	}
	
}
