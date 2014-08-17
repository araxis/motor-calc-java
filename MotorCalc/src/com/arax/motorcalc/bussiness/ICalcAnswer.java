package com.arax.motorcalc.bussiness;

import com.arax.motorcalc.bussiness.command.CalcAnswerCommand;
import com.arax.motorcalc.data.Answer;

public interface ICalcAnswer extends ICommandHandler<CalcAnswerCommand, Answer> {

}
