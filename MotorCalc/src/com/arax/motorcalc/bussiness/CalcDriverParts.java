package com.arax.motorcalc.bussiness;

import roboguice.RoboGuice;
import roboguice.inject.RoboInjector;

import com.arax.motorcalc.MotorCalcApplication;
import com.arax.motorcalc.bussiness.command.CalcDriverPartsCommand;
import com.arax.motorcalc.data.DriverPartsResult;
import com.arax.motorcalc.data.StartMode;


public class CalcDriverParts implements ICalcDriverParts {
	

	
	final RoboInjector injector = RoboGuice.getInjector(MotorCalcApplication.getAppContext());
	
	@Override
	public DriverPartsResult Execute(CalcDriverPartsCommand param)
			throws Exception {
	
		ICommandHandler<CalcDriverPartsCommand, DriverPartsResult> command=null;

		StartMode startMode=param.getStartmode();
		
		switch (startMode) {
		case DOL:		
			command=injector.getInstance(CalcDolParts.class);
			break;
		case SD:			
			command=injector.getInstance(CalcSdParts.class);
			break;
		case SSD:
			command=injector.getInstance(CalcSsdParts.class);
			break;
		case VSD:	
			command=injector.getInstance(CalcVsdParts.class);
			break;
		default:
			break;
		}
		
	if(command==null) return null;
		
		
		return command.Execute(param);
	}

}
