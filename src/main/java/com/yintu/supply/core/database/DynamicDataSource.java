package com.yintu.supply.core.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource {
	private static final Logger log = LoggerFactory.getLogger(DynamicDataSource.class);

    @Override
    protected Object determineCurrentLookupKey() {
    	DBTypeEnum dbType = DBContextHolder.getDBType();
        log.debug("数据源为：", dbType);
        return dbType;
    }

}