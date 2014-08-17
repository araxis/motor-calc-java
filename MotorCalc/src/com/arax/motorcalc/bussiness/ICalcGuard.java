package com.arax.motorcalc.bussiness;

import com.arax.motorcalc.bussiness.command.CalcGuardCommand;
import com.arax.motorcalc.data.IBimetal;

public interface ICalcGuard extends ICommandHandler<CalcGuardCommand, IBimetal>{

}
