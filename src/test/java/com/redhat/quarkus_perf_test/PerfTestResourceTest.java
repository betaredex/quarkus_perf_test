package com.redhat.quarkus_perf_test;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class PerfTestResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/test")
          .then()
             .statusCode(200)
             .body(is("hello"));
    }

}