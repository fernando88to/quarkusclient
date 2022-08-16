package com.fernando;

import io.quarkus.redis.client.reactive.ReactiveRedisClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.Optional;

@Path("/hello")
public class ExampleResource {

    @Inject
    MyRedisCache myRedisCache;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        myRedisCache.set("x", new BusinessObject(5, Arrays.asList("a", "b")));
        return "Hello from RESTEasy Reactive";
    }
    @GET
    @Path("/pegar")
    public Response pegar() {
        BusinessObject businessObject = myRedisCache.get("x");
        if(businessObject==null){
            return Response.ok().entity("Nada foi encontrado").build();
        }

        return Response.ok().entity(businessObject).build();
    }
}