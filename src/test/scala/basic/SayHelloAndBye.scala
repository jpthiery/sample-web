package basic

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class SayHelloAndBye extends Simulation {

  var host = scala.util.Properties.envOrElse("host", "localhost" )
  var port = java.lang.Integer.getInteger("port", 1).toInt
  val baseurl = System.getProperty("baseUrl", "http://localhost:4567")

  val httpConf = http
    .baseURL(baseurl)  // Here is the root for all relative URLs
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0")


  val scn = scenario("Scenario Hello and Bye") // A scenario is a chain of requests and pauses
    .exec(http("request_hello")
    .get("/user/Jean-Pasca"))
    .pause(7) // Note that Gatling has recorder real time pauses
    .exec(http("request_bye")
    .get("/user/bye/Marcel"))

  setUp(scn.inject(atOnceUsers(1)).protocols(httpConf))
}
