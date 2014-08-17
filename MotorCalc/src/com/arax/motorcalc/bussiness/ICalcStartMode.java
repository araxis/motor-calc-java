package com.arax.motorcalc.bussiness;
import com.arax.motorcalc.bussiness.command.CalcStartModeCommand;
import com.arax.motorcalc.data.StartMode;
public interface ICalcStartMode extends ICommandHandler<CalcStartModeCommand,  StartMode> {

}
