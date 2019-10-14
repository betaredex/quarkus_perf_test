package com.redhat.quarkus_perf_test;

import java.util.*;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/test")
public class PerfTestResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/memory/bigarray")
    public String bigArray() {
        byte b[] = new byte[1048576]; // 2^20 (1 MB)
        /*
        try {
            Thread.sleep(200000);
        }
        catch(Exception e) {
            System.out.println(e);
        }
        */
        return "big array";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/memory/lotsofarrays")
    public String lotsOfArrays() {
        byte a[][] = new byte[1024][];
        for(int i=0; i<1024; i++) {
            byte b[] = new byte[1024]; // 2^10, aka 1 KB
            a[i] = b;
        }
        /*        
        try {
            Thread.sleep(200000);
        }
        catch(Exception e) {
            System.out.println(e);
        }
        */
        return "lots of arrays";
    }
}
