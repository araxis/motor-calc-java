package com.arax.motorcalc.bussiness;

import java.sql.SQLException;

import com.arax.motorcalc.bussiness.command.CalcDriverPartsCommand;
import com.arax.motorcalc.data.Contactor;
import com.arax.motorcalc.data.DataBaseHelper;
import com.arax.motorcalc.data.DriverPartsResult;
import com.arax.motorcalc.data.Ssd;
import com.google.inject.Inject;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;

public class CalcSsdParts implements ICalcSsdParts {

	
	@Inject DataBaseHelper  dbHelper;
	
	
	 
	
	@Override
	public DriverPartsResult Execute(CalcDriverPartsCommand param)throws Exception {
		
		Double current=param.getCurrent();
		Double power=param.getPower();
		Boolean isbidirect=param.getIsbidirect();
		
		DriverPartsResult ret = new DriverPartsResult();
		
		Ssd ssd = findSsd(power);
		ret.setDriver(ssd);
		
		
		if(isbidirect){
			
			Contactor cBidirect = findBidirectContactor(current);
			ret.setcBidirect(cBidirect);
			
		}
		
		
	
		
		
		
		return ret;
	}




	private Contactor findBidirectContactor(Double current) throws SQLException {
		Dao<Contactor, Integer> contactorDao=dbHelper.getDao(Contactor.class);
		QueryBuilder<Contactor, Integer> queryBuilder =contactorDao.queryBuilder();
		queryBuilder.where().ge(Contactor.CURRENT_FIELD_NAME, current);		
		Contactor cBidirect=contactorDao.queryForFirst(queryBuilder.prepare());
		return cBidirect;
	}




	private Ssd findSsd(Double power) throws SQLException {
		Dao<Ssd, Integer> ssdDao=dbHelper.getDao(Ssd.class);
		QueryBuilder<Ssd, Integer> queryBuilder1 =ssdDao.queryBuilder();
		queryBuilder1.where().ge(Ssd.Power_FIELD_NAME, power);		
		Ssd  ssd=ssdDao.queryForFirst(queryBuilder1.prepare());
		return ssd;
	}

}
