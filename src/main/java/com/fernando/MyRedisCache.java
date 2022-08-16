package com.fernando;

import io.quarkus.redis.datasource.RedisDataSource;
import io.quarkus.redis.datasource.string.StringCommands;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MyRedisCache {

    private final StringCommands<String, BusinessObject> commands;

    public MyRedisCache(RedisDataSource ds) {
        commands = ds.string(BusinessObject.class);
    }

    public BusinessObject get(String key) {
        return commands.get(key);
    }

    public void set(String key, BusinessObject bo) {
        commands.setex(key, 5, bo); // Expira depois de 5 segundos
    }
}
