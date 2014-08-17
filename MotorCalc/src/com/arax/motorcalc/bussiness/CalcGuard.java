package com.arax.motorcalc.bussiness;

import java.sql.SQLException;

import com.arax.motorcalc.bussiness.command.CalcGuardCommand;
import com.arax.motorcalc.data.Bimetal;
import com.arax.motorcalc.data.DataBaseHelper;
import com.arax.motorcalc.data.IBimetal;
import com.arax.motorcalc.data.StartMode;
import com.arax.motorcalc.data.Tmb;
import com.google.inject.Inject;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;

public class CalcGuard implements ICalcGuard {

	 @Inject DataBaseHelper  dbHelper;
		
	@Override
	public IBimetal Execute(CalcGuardCommand param) throws Exception {
		StartMode startmode=param.getStartmode();
		double current=param.getCurrent();
		Class<?> keytype=param.getKeyClass();
		if(keytype==Tmb.class){return null;}
	
		
		
		switch (startmode) {
		case DOL:
			return findBimetal(current);
			
		case SD:
		    double appliedCurrent = current / Math.sqrt(3);
			return findBimetal(appliedCurrent);
			
		default:
			break;
		
		}
		return null;
	
		
	}

	private IBimetal findBimetal(double current) throws SQLException {
		Dao<Bimetal, Integer> bimetalDao=dbHelper.getDao(Bimetal.class);
		QueryBuilder<Bimetal, Integer> queryBuilder =bimetalDao.queryBuilder();
		Where<Bimetal, Integer> where = queryBuilder.where();
		Where<Bimetal, Integer> query1 = where.le(Bimetal.MINCURRENT_FIELD_NAME, current);
		Where<Bimetal, Integer> query2 = where.gt(Bimetal.MAXCURRENT_FIELD_NAME, current);
        @SuppressWarnings("unchecked")
		Where<Bimetal, Integer> query = where.and(query1,query2);
		Bimetal bimetal=bimetalDao.queryForFirst(query.prepare());
		return bimetal;
	}

}


