package com.arax.motorcalc.bussiness;

import java.text.NumberFormat;

import com.arax.motorcalc.bussiness.command.CalcAnswerCommand;
import com.arax.motorcalc.bussiness.command.CalcCircuitTypeCommand;
import com.arax.motorcalc.bussiness.command.CalcCurrentCommand;
import com.arax.motorcalc.bussiness.command.CalcDriverPartsCommand;
import com.arax.motorcalc.bussiness.command.CalcGuardCommand;
import com.arax.motorcalc.bussiness.command.CalcKeyCommand;
import com.arax.motorcalc.data.Acb;
import com.arax.motorcalc.data.Answer;
import com.arax.motorcalc.data.AnswerItem;
import com.arax.motorcalc.data.AnswerType;
import com.arax.motorcalc.data.DriverPartsResult;
import com.arax.motorcalc.data.IBimetal;
import com.arax.motorcalc.data.ICircuitBreacker;
import com.arax.motorcalc.data.IContactor;
import com.arax.motorcalc.data.IDriver;
import com.arax.motorcalc.data.Mcb;
import com.arax.motorcalc.data.Mccb;
import com.arax.motorcalc.data.StartMode;
import com.arax.motorcalc.data.Tmb;
import com.arax.motorcalc.data.Vsd;
import com.google.inject.Inject;

public class CalcAnswer implements ICalcAnswer {

	
	 @Inject CalcGuard  guardService;
	 @Inject CalcKey  keyService;
	 @Inject CalcCurrent  currentService;
	 @Inject CalcDriverParts  driverService;
	 @Inject CalcCircuitType  typeService;
	
	@Override
	public Answer Execute(CalcAnswerCommand param) throws Exception {

		Answer ret=new Answer();
		
		double power=param.getPower();
		double powerfactor=param.getPowerfactor();
		double effeciency=param.getEffeciency();
		StartMode startmode=param.getStartmode();
		Boolean isbidirect=param.GetIsbidirect();
		int voltage=param.getVoltage();
		
		double current;
	
		current = populateCurrentToAnswer(ret, power, powerfactor, effeciency,voltage);
		
		Class<?> keytype = populateKeyToAnswer(ret, current);
		
		
		IBimetal guard= populateGuardToAnswer(ret, startmode, current, keytype);
		
		populateDriverPartsToAnswer(ret, power, startmode, isbidirect, current);
		
		CalcCircuitTypeCommand calcTypeCommand=new CalcCircuitTypeCommand(startmode,keytype,guard!=null,isbidirect,false);
		
		int type=typeService.Execute(calcTypeCommand);
		
		ret.setTypeResurceId(type);
		
		
		
		return ret;
	}

	private void populateDriverPartsToAnswer(Answer ret, double power,
			StartMode startmode, Boolean isbidirect, double current)
			throws Exception {
		CalcDriverPartsCommand calcdriverpartscommand=new CalcDriverPartsCommand(power,current,startmode,isbidirect);
		
		DriverPartsResult result=driverService.Execute(calcdriverpartscommand);
		
		fillToAnswer(ret, result);
	}

	private IBimetal populateGuardToAnswer(Answer ret, StartMode startmode,
			double current, Class<?> keytype) throws Exception {
		CalcGuardCommand calcguardcommand=new CalcGuardCommand(current,startmode,keytype);
		
		IBimetal guard=guardService.Execute(calcguardcommand);
		
		if(guard!=null){
			ret.getItems().add(new AnswerItem(AnswerType.Guard,guard.getTag()));
		}
		
		return guard;
	}

	

	private Class<?> populateKeyToAnswer(Answer ret, double current)
			throws Exception {
		CalcKeyCommand calckeycommand =new CalcKeyCommand(current);
		ICircuitBreacker key=keyService.Execute(calckeycommand);
	Class<?> keytype=null;
		if(key!=null){
			
			AnswerType keyType = getKeyType(key);
			
			ret.getItems().add(new AnswerItem(keyType,key.getTag()));
			keytype= key.getClass();
			
			
		}
		return keytype;
	}

	private AnswerType getKeyType(ICircuitBreacker key) {
	
		
		if(key.getClass()==Acb.class){
		return	AnswerType.ACB;
		
		}
		if(key.getClass()==Mcb.class){
				return AnswerType.MCB;

		}
		
		if(key.getClass()==Mccb.class){
			return AnswerType.MCCB;
			
		}
		if(key.getClass()==Tmb.class){
			return AnswerType.TMB;
			}
		return AnswerType.Known;
	
	}

	private double populateCurrentToAnswer(Answer ret, double power,
			double powerfactor, double effeciency, int voltage) {
		double current;
		CalcCurrentCommand currentcommand=new CalcCurrentCommand(power,powerfactor,effeciency,voltage);
		current=currentService.Execute(currentcommand);
		
		
		
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMinimumFractionDigits(2);
		nf.setMaximumFractionDigits(2);
		String output = nf.format(current);
		
		
		ret.getItems().add(new AnswerItem(AnswerType.Current,"Current:"+output+" A"));
		return current;
	}

	private void fillToAnswer(Answer ret, DriverPartsResult result) {
		if(result!=null){
			IContactor c1=result.getC1();
			IContactor c2=result.getC2();
			IContactor c3=result.getC3();
			IContactor cBidirect=result.getcBidirect();
			IDriver driver=result.getDriver();
			if(c1!=null){ret.getItems().add(new AnswerItem(AnswerType.C1,c1.getTag()));}
			if(c2!=null){ret.getItems().add(new AnswerItem(AnswerType.C2,c2.getTag()));}
			if(c3!=null){ret.getItems().add(new AnswerItem(AnswerType.C3,c3.getTag()));}
			if(cBidirect!=null){ret.getItems().add(new AnswerItem(AnswerType.CBidirect,cBidirect.getTag()));}
			if(driver!=null)
			{
				AnswerType type=AnswerType.SSD;
				if(driver.getClass()==Vsd.class){
					 type = AnswerType.VSD;
				}
				ret.getItems().add(new AnswerItem(type,driver.getTag()));
				
			}
		}
	}


	 


}
