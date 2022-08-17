package com.fernando;

import io.smallrye.mutiny.Uni;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.Optional;

@Path("/cliente")
public class ClienteResource {

    @Inject
    MyRedisCacheService myRedisCacheService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String index() {
        return "oi";
    }

    @GET
    @Path("/salvar")
    @Produces(MediaType.TEXT_PLAIN)
    public String salvar() {
        myRedisCacheService.set("x", new ArquivoPDFRedis(5, Arrays.asList("a", "b", "sfsdfsd", "sdfsdf")));
        return "Salvou no redis em definitivo";
    }

    @GET
    @Path("/salvar2")
    @Produces(MediaType.TEXT_PLAIN)
    public String salvarComExpiracao() {
        myRedisCacheService.set("x", 5,
                new ArquivoPDFRedis(5, Arrays.asList("a", "b", "sfsdfsd", "sdfsdf")));
        return "Salvou no redis por alguns segundos";
    }

    @GET
    @Path("/pegar")
    public ArquivoPDFRedis pegar() {
        Optional<ArquivoPDFRedis> arquivoPDFRedis = myRedisCacheService.get("x");
        //retorna http 200 se tiver o dado e 204 se não tiver o dado
        return arquivoPDFRedis.orElse(null);
    }

}