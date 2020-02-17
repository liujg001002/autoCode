package com.yintu.supply.core.database;

public class DBContextHolder {
	// 当前线程存入当前数据源信息
	private static final ThreadLocal<DBTypeEnum> contextHolder = new ThreadLocal<DBTypeEnum>();

	// 改变当前数据源
	public static void setDBType(DBTypeEnum dbType) {
		contextHolder.set(dbType);
	}

	// 获取当前数据源
	public static DBTypeEnum getDBType() {
		return contextHolder.get();
	}

	public static void clearDBType() {
		contextHolder.remove();
	}
}