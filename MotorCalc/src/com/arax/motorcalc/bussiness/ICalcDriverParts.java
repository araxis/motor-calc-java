package com.arax.motorcalc.bussiness;

import com.arax.motorcalc.bussiness.command.CalcDriverPartsCommand;
import com.arax.motorcalc.data.DriverPartsResult;

public interface ICalcDriverParts extends ICommandHandler<CalcDriverPartsCommand, DriverPartsResult> {

}
