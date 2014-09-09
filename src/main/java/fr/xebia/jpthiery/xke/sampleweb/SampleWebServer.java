package fr.xebia.jpthiery.xke.sampleweb;

import spark.Spark;

import static spark.Spark.*;
import static spark.SparkBase.staticFileLocation;

/**
 * Created by jpthiery on 09/09/2014.
 */
public class SampleWebServer {

    public SampleWebServer() {
        super();
    }

    public void runServer() {
        staticFileLocation("/");

        get("/", (request, response) ->
             "HelloWorld"
        );
    }

    public static void main(String[] args) {
        SampleWebServer webServer = new SampleWebServer();
        webServer.runServer();
    }

}
