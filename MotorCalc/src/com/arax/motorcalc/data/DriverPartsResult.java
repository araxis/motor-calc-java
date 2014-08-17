package com.arax.motorcalc.data;


public class DriverPartsResult {

	private IContactor c1;
	private IContactor c2;
	private IContactor c3;
	private IContactor cBypass;
	private IContactor cBidirect;
	private IDriver driver;
	
	
	
	
	public IContactor getC1() {
		return c1;
	}
	public void setC1(IContactor c1) {
		this.c1 = c1;
	}
	public IContactor getC2() {
		return c2;
	}
	public void setC2(IContactor c2) {
		this.c2 = c2;
	}
	public IContactor getC3() {
		return c3;
	}
	public void setC3(IContactor c3) {
		this.c3 = c3;
	}
	public IContactor getcBypass() {
		return cBypass;
	}
	public void setcBypass(IContactor cBypass) {
		this.cBypass = cBypass;
	}
	public IContactor getcBidirect() {
		return cBidirect;
	}
	public void setcBidirect(IContactor cBidirect) {
		this.cBidirect = cBidirect;
	}
	public IDriver getDriver() {
		return driver;
	}
	public void setDriver(IDriver driver) {
		this.driver = driver;
	}
}
