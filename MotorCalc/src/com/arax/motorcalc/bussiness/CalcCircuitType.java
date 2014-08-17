package com.arax.motorcalc.bussiness;

import com.arax.motorcalc.R;
import com.arax.motorcalc.bussiness.command.CalcCircuitTypeCommand;
import com.arax.motorcalc.data.Mccb;
import com.arax.motorcalc.data.StartMode;
import com.arax.motorcalc.data.Tmb;

public class CalcCircuitType implements ICalcCircuitType{

	@Override
	public Integer Execute(CalcCircuitTypeCommand param) throws Exception {
		
		 StartMode startmode=param.getStartmode(); 
		 Class<?>  keyType=param.getKeyType();
		 Boolean hasGuard=param.getHasGuard();
		 Boolean isBidirect=param.getIsBidirect();
		 Boolean hasCap=param.getHasCap();
		 if(startmode==StartMode.DOL & keyType==Tmb.class & !hasGuard & !hasCap & !isBidirect){return R.drawable.doltmb;}
		 if(startmode==StartMode.DOL & keyType==Tmb.class & !hasGuard & !hasCap & isBidirect){return R.drawable.doltmbbidirect;}
		 if(startmode==StartMode.DOL & keyType==Tmb.class & hasGuard & !hasCap & !isBidirect){return R.drawable.doltmbbimetal;}
		 if(startmode==StartMode.DOL & keyType==Tmb.class & hasGuard & !hasCap & isBidirect){return R.drawable.doltmbbimetalbidirect;}
		 if(startmode==StartMode.DOL & keyType==Mccb.class & hasGuard & !hasCap & !isBidirect){return R.drawable.dolmccbbimetal;}
		 if(startmode==StartMode.DOL & keyType==Mccb.class & hasGuard & !hasCap & isBidirect){return R.drawable.dolmccbbimetal;}
//		 
		 if(startmode==StartMode.SD & keyType==Tmb.class & !hasGuard & !hasCap & !isBidirect){return R.drawable.sdtmb;}
		 if(startmode==StartMode.SD & keyType==Tmb.class & hasGuard & !hasCap & !isBidirect){return R.drawable.sdtmbbimetal;}
		 if(startmode==StartMode.SD & keyType==Mccb.class & hasGuard & !hasCap & !isBidirect){return R.drawable.sdbimetalmccb;}
//		 
		 if(startmode==StartMode.SSD & keyType==Tmb.class & !hasGuard & !hasCap & !isBidirect){return R.drawable.ssdtmb;}
		 if(startmode==StartMode.SSD & keyType==Mccb.class & !hasGuard & !hasCap & !isBidirect){return R.drawable.ssdmccb;}
//		 
		 if(startmode==StartMode.VSD & keyType==Tmb.class & !hasGuard & !hasCap & !isBidirect){return R.drawable.vsdtmb;}
		 if(startmode==StartMode.VSD & keyType==Mccb.class & !hasGuard & !hasCap & !isBidirect){return R.drawable.vsdmccb;}
		return 0;
	}

}
