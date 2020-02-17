package com.yintu.supply.core.utils;

import com.yintu.supply.core.database.DBContextHolder;
import com.yintu.supply.core.database.DBTypeEnum;

public class DataSourceSwitcher {

	public static void execute(DBTypeEnum dbType, CallBack callBack){
		DBContextHolder.setDBType(dbType);
		callBack.run();
		DBContextHolder.clearDBType();
	}
	
	public static abstract class CallBack {
		public abstract void run();
	}
	
}
