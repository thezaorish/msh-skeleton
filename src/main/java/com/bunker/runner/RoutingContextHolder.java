package com.bunker.runner;

import com.bunker.skeleton.dao.RoutingType;
import org.springframework.util.Assert;

public class RoutingContextHolder {

    private static final ThreadLocal<RoutingType> contextHolder = new ThreadLocal<RoutingType>();

    public static void setRoutingType(RoutingType routingType) {
        Assert.notNull(routingType, "routingType cannot be null");
        contextHolder.set(routingType);
    }

    public static RoutingType getRoutingType() {
        return (RoutingType) contextHolder.get();
    }

    public static void clearRoutingType() {
        contextHolder.remove();
    }

}
