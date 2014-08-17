package com.arax.motorcalc.bussiness.command;

import com.arax.motorcalc.data.StartMode;

public class CalcCircuitTypeCommand {

	
	private StartMode startmode;
	private Class<?>  keyType;
	private Boolean hasGuard;
	private Boolean isBidirect;
	private Boolean hasCap;
	
	
	public CalcCircuitTypeCommand(StartMode startmode,Class<?>  keyType,Boolean hasGuard,Boolean isBidirect, Boolean hasCap) {
		this.setHasCap(hasCap);
		this.setHasGuard(hasGuard);
		this.setIsBidirect(isBidirect);
		this.setStartmode(startmode);
		this.setKeyType(keyType);
		
	}
	
	public StartMode getStartmode() {
		return startmode;
	}
	public void setStartmode(StartMode startmode) {
		this.startmode = startmode;
	}
	public Class<?> getKeyType() {
		return keyType;
	}
	public void setKeyType(Class<?> keyType) {
		this.keyType = keyType;
	}
	public Boolean getHasGuard() {
		return hasGuard;
	}
	public void setHasGuard(Boolean hasGuard) {
		this.hasGuard = hasGuard;
	}
	public Boolean getIsBidirect() {
		return isBidirect;
	}
	public void setIsBidirect(Boolean isBidirect) {
		this.isBidirect = isBidirect;
	}
	public Boolean getHasCap() {
		return hasCap;
	}
	public void setHasCap(Boolean hasCap) {
		this.hasCap = hasCap;
	}
		
	
	
	
}
