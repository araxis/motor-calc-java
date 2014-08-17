package com.arax.motorcalc.bussiness.command;

import com.arax.motorcalc.data.StartMode;

public class CalcDriverPartsCommand {

	private Double power;
	private Double current;
	private StartMode startmode;
	private Boolean isbidirect;
	
	public CalcDriverPartsCommand(Double power,Double current,StartMode startmode,Boolean isbidirect) {
		this.setPower(power);
		this.setCurrent(current);
		this.setStartmode(startmode);
		this.setIsbidirect(isbidirect);
	}
	public Double getPower() {
		return power;
	}
	public void setPower(Double power) {
		this.power = power;
	}
	public Double getCurrent() {
		return current;
	}
	public void setCurrent(Double current) {
		this.current = current;
	}
	public StartMode getStartmode() {
		return startmode;
	}
	public void setStartmode(StartMode startmode) {
		this.startmode = startmode;
	}
	public Boolean getIsbidirect() {
		return isbidirect;
	}
	public void setIsbidirect(Boolean isbidirect) {
		this.isbidirect = isbidirect;
	}
	
	
}
