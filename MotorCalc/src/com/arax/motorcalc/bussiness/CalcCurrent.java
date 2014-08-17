package com.arax.motorcalc.bussiness;

import com.arax.motorcalc.bussiness.command.CalcCurrentCommand;

public class CalcCurrent implements ICalcCurrent {

	private int phase=3;
	@Override
	public Double Execute(CalcCurrentCommand param) {
		 double ret1 = param.getPower() * 1000 / (Math.sqrt(this.phase) * param.getVoltage() * param.getPowerfactor() * param.getEffeciency());

         return ret1;
	}

}
