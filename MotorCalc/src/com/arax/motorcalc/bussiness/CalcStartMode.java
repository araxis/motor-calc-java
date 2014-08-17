package com.arax.motorcalc.bussiness;

import com.arax.motorcalc.bussiness.command.CalcStartModeCommand;
import com.arax.motorcalc.data.StartMode;
import com.google.inject.Inject;

public class CalcStartMode implements ICalcStartMode{
	
	
	@Inject
	public CalcStartMode() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public StartMode Execute(CalcStartModeCommand param) {
		 if (param.getPower() < 15) return StartMode.DOL;
         return param.getPower() < 132 ? StartMode.SD : StartMode.SSD;
	}

}
