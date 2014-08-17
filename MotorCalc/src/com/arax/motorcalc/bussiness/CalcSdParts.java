package com.arax.motorcalc.bussiness;

import java.sql.SQLException;

import com.arax.motorcalc.bussiness.command.CalcDriverPartsCommand;
import com.arax.motorcalc.data.Contactor;
import com.arax.motorcalc.data.DataBaseHelper;
import com.arax.motorcalc.data.DriverPartsResult;
import com.google.inject.Inject;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;

public class CalcSdParts implements ICalcSdParts {

	@Inject DataBaseHelper  dbHelper;
	
	@Override
	public DriverPartsResult Execute(CalcDriverPartsCommand param)
			throws Exception {
		Double current=param.getCurrent();
		Double appliedCurrent = current / Math.sqrt(3);		
		Boolean isbidirect=param.getIsbidirect();
		
		
		DriverPartsResult ret = new DriverPartsResult();
		
		Dao<Contactor, Integer> contactorDao=dbHelper.getDao(Contactor.class);
		
		Contactor c3 = findC3(appliedCurrent, contactorDao);
		Contactor c1 = findC1(appliedCurrent, contactorDao);
		
		
		
		ret.setC1(c1);
		ret.setC2(c1);
		ret.setC3(c3);
		if(isbidirect){
			ret.setcBidirect(c1);
		}
		
		return ret;
	}

	private Contactor findC3(Double appliedCurrent,Dao<Contactor, Integer> contactorDao) throws SQLException {
		QueryBuilder<Contactor, Integer> queryBuilder =contactorDao.queryBuilder();
		queryBuilder.orderBy(Contactor.CURRENT_FIELD_NAME, false);
		queryBuilder.where().lt(Contactor.CURRENT_FIELD_NAME, appliedCurrent);	
		Contactor c2=contactorDao.queryForFirst(queryBuilder.prepare());
		return c2;
	}

	private Contactor findC1(Double appliedCurrent,Dao<Contactor, Integer> contactorDao) throws SQLException {
		QueryBuilder<Contactor, Integer> queryBuilder =contactorDao.queryBuilder();
		queryBuilder.orderBy(Contactor.CURRENT_FIELD_NAME,true);
		queryBuilder.where().ge(Contactor.CURRENT_FIELD_NAME, appliedCurrent);		
		Contactor c1=contactorDao.queryForFirst(queryBuilder.prepare());
		return c1;
	}

}
