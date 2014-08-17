package com.arax.motorcalc.bussiness;

import java.sql.SQLException;

import com.arax.motorcalc.bussiness.command.CalcKeyCommand;
import com.arax.motorcalc.data.Acb;
import com.arax.motorcalc.data.DataBaseHelper;
import com.arax.motorcalc.data.ICircuitBreacker;
import com.arax.motorcalc.data.Mccb;
import com.arax.motorcalc.data.Tmb;
import com.google.inject.Inject;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;

public class CalcKey implements ICalcKey{
	
	 @Inject DataBaseHelper  dbHelper;
	
	 
	@Override
	public ICircuitBreacker Execute(CalcKeyCommand param) throws Exception {
		
		double current=param.getCurrent();
		
		if(current<63){
			return findTmb(current);
		}
		
		double sparedCurrent = current * 1.1;
		if(current>=63 && current <1600){
			return findMccb(sparedCurrent);
		}
		
		
		return findAcb(sparedCurrent);
		
	}


	private ICircuitBreacker findAcb(double sparedCurrent) throws SQLException {
		Dao<Acb, Integer> acbDao=dbHelper.getDao(Acb.class);
		QueryBuilder<Acb, Integer> queryBuilder =acbDao.queryBuilder();
		queryBuilder.where().gt(Acb.CURRENT_FIELD_NAME, sparedCurrent);
		
		Acb acb=acbDao.queryForFirst(queryBuilder.prepare());
		return acb;
	}


	private ICircuitBreacker findMccb(double sparedCurrent) throws SQLException {
		Dao<Mccb, Integer> mccbDao=dbHelper.getDao(Mccb.class);
		QueryBuilder<Mccb, Integer> queryBuilder =mccbDao.queryBuilder();
		queryBuilder.where().gt(Mccb.CURRENT_FIELD_NAME, sparedCurrent);
		
		Mccb mccb=mccbDao.queryForFirst(queryBuilder.prepare());
		return mccb;
	}


	private ICircuitBreacker findTmb(double current) throws SQLException {
		Dao<Tmb, Integer> tmbDao=dbHelper.getDao(Tmb.class);
		QueryBuilder<Tmb, Integer> queryBuilder =tmbDao.queryBuilder();
		queryBuilder.where().gt(Tmb.MAXCURRENT_FIELD_NAME, current);
		
		Tmb tmb=tmbDao.queryForFirst(queryBuilder.prepare());
		return tmb;
	}

}
