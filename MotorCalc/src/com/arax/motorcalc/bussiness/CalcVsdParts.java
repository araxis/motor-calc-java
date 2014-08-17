package com.arax.motorcalc.bussiness;

import java.sql.SQLException;

import com.arax.motorcalc.bussiness.command.CalcDriverPartsCommand;
import com.arax.motorcalc.data.DataBaseHelper;
import com.arax.motorcalc.data.DriverPartsResult;
import com.arax.motorcalc.data.Vsd;
import com.google.inject.Inject;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;

public class CalcVsdParts implements ICalcVsdParts{

	@Inject DataBaseHelper  dbHelper;
	
	@Override
	public DriverPartsResult Execute(CalcDriverPartsCommand param)
			throws Exception {
		
	
		
		Double power=param.getPower();
	
		
		DriverPartsResult ret = new DriverPartsResult();
		
		Vsd vsd = findVsd(power);
		ret.setDriver(vsd);
		
		return ret;

}

	private Vsd findVsd(Double power) throws SQLException {
		Dao<Vsd, Integer> vsdDao=dbHelper.getDao(Vsd.class);
		QueryBuilder<Vsd, Integer> queryBuilder1 =vsdDao.queryBuilder();
		queryBuilder1.where().ge(Vsd.Power_FIELD_NAME, power);		
		Vsd  vsd=vsdDao.queryForFirst(queryBuilder1.prepare());
		return vsd;
	}
	}
