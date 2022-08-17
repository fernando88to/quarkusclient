package com.fernando;

import io.quarkus.redis.datasource.RedisDataSource;
import io.quarkus.redis.datasource.string.StringCommands;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
public class MyRedisCacheService {

    private final StringCommands<String, ArquivoPDFRedis> commands;

    public MyRedisCacheService(RedisDataSource ds) {
        commands = ds.string(ArquivoPDFRedis.class);
    }

    public Optional<ArquivoPDFRedis> get(String key) {
        return Optional.ofNullable(commands.get(key));
    }

    public void set(String key, ArquivoPDFRedis bo) {
        commands.set(key, bo);
    }
    public void set(String key, long segundos , ArquivoPDFRedis bo) {
        commands.setex(key, segundos, bo); // Expira depois de 5 segundos
    }
}
