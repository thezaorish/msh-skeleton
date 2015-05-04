package com.bunker.skeleton.dao;

import com.bunker.runner.RoutingContextHolder;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class CustomDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return RoutingContextHolder.getRoutingType();
    }

}
