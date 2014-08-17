package com.arax.motorcalc.bussiness.command;

import com.arax.motorcalc.data.StartMode;

public class CalcGuardCommand {

	private StartMode startmode;
	private double current;
	private Class<?> keyClass;
	
	public CalcGuardCommand(double current,StartMode startmode,Class<?> keyType) {
		this.setCurrent(current);
		this.setStartmode(startmode);
		this.setKeyClass(keyType);
	}
	
	public StartMode getStartmode() {
		return startmode;
	}
	public void setStartmode(StartMode startmode) {
		this.startmode = startmode;
	}
	public double getCurrent() {
		return current;
	}
	public void setCurrent(double current) {
		this.current = current;
	}



	public Class<?> getKeyClass() {
		return keyClass;
	}

	public void setKeyClass(Class<?> keyClass) {
		this.keyClass = keyClass;
	}
	
}
