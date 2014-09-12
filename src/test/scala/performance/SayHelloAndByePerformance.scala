package performance

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class SayHelloAndByePerformance extends Simulation {

  val baseurl = System.getProperty("baseUrl", "http://localhost:4567")
  val datas = csv("username.csv").circular

  val httpConf = http
    .baseURL(baseurl)  // Here is the root for all relative URLs
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0")


  val scn = scenario("Scenario Hello and Bye") // A scenario is a chain of requests and pauses
    .repeat(4) {

      feed(datas)
      .exec(http("request_hello")
      .get("/user/${username}")
      .check(status.is(200))
      .check(regex("""Hello ${username}""").exists))
      .pause(1 seconds)
      .exec(http("request_bye")
      .get("/user/bye/${username}")
      .check(status.is(200))
      .check(regex("""Bye ${username}""").exists))


  }
  setUp(scn.inject(rampUsersPerSec(10) to (100) during (1 minutes)).protocols(httpConf))
}
