package com.arax.motorcalc.bussiness;

import com.arax.motorcalc.bussiness.command.*;
import com.arax.motorcalc.data.ICircuitBreacker;

public interface ICalcKey extends ICommandHandler<CalcKeyCommand,ICircuitBreacker> {

}
