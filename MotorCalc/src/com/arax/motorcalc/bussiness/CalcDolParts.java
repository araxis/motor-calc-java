package com.arax.motorcalc.bussiness;

import java.sql.SQLException;

import com.arax.motorcalc.bussiness.command.CalcDriverPartsCommand;
import com.arax.motorcalc.data.Contactor;
import com.arax.motorcalc.data.DataBaseHelper;
import com.arax.motorcalc.data.DriverPartsResult;
import com.google.inject.Inject;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;

public class CalcDolParts implements ICalcDolParts {

	 @Inject DataBaseHelper  dbHelper;
	
	@Override
	public DriverPartsResult Execute(CalcDriverPartsCommand param)
			throws Exception {
		
		Double current=param.getCurrent();
		Boolean isbidirect=param.getIsbidirect();
		DriverPartsResult ret = new DriverPartsResult();
		
		Contactor contactor = findContactor(current);
		
		ret.setC1(contactor);
		
		if(isbidirect){
			ret.setcBidirect(contactor);
		}
		
		return ret;
	}

	private Contactor findContactor(Double current) throws SQLException {
		Dao<Contactor, Integer> contactorDao=dbHelper.getDao(Contactor.class);
		QueryBuilder<Contactor, Integer> queryBuilder =contactorDao.queryBuilder();
		queryBuilder.where().ge(Contactor.CURRENT_FIELD_NAME, current);
		
		Contactor contactor=contactorDao.queryForFirst(queryBuilder.prepare());
		return contactor;
	}

}
