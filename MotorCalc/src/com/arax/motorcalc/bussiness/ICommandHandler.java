package com.arax.motorcalc.bussiness;

public interface ICommandHandler<TParam,TResult> {

	abstract TResult Execute(TParam param) throws Exception;
	
}
