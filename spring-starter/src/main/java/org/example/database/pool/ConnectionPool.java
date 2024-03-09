package org.example.database.pool;

import java.util.List;
import java.util.Map;

public class ConnectionPool {
    private final String name;
    private final Integer size;
    private final List<Object> args;
    private final Map<String, Object> properties;

    public ConnectionPool(String name, Integer size, List<Object> args, Map<String, Object> properties) {
        this.name = name;
        this.size = size;
        this.args = args;
        this.properties = properties;
    }

    private void init(){
        System.out.println("Pool init");
    }

    private void destroy(){
        System.out.println("Pool destroy");
    }
}
