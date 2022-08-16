package com.fernando;

import io.quarkus.redis.datasource.ReactiveRedisDataSource;
import io.quarkus.redis.datasource.keys.ReactiveKeyCommands;
import io.smallrye.mutiny.Uni;

import java.util.List;

public class IncrementService {

    private ReactiveKeyCommands<String> keyCommands;

    public IncrementService(ReactiveRedisDataSource reactive) {
        keyCommands = reactive.key();



    }
    void set(String key, Long value) {

    }

    Uni<Void> del(String key) {
        return keyCommands.del(key)
                .replaceWithVoid();
    }

    Uni<List<String>> keys() {
        return keyCommands.keys("*");
    }

}
