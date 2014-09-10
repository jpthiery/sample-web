package fr.xebia.jpthiery.xke.sampleweb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static spark.Spark.get;
import static spark.SparkBase.staticFileLocation;

/**
 * Created by jpthiery on 09/09/2014.
 */
public class SampleWebServer {

    private static final Logger LOGGER = LoggerFactory.getLogger(SampleWebServer.class);

    public SampleWebServer() {
        super();
    }

    public void runServer() {
        staticFileLocation("/webapp");

        get("/user/:name", (request, response) -> String.format("Hello %s", request.params("name")));


        get("/user/bye/:name", (request, response) -> String.format("Bye %s", request.params("name")));
    }

    public static void main(String[] args) {
        SampleWebServer webServer = new SampleWebServer();
        webServer.runServer();
    }

}
