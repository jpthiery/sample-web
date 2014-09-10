package fr.xebia.jpthiery.xke.sampleweb.services;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by jpthiery on 10/09/2014.
 */
public class DefaultGreeterServiceTest {

    private GreeterService greeterService;

    public DefaultGreeterServiceTest() {
        super();
    }

    @Before
    public void setup() {
        greeterService = new DefaultGreeterService();
    }

    @Test
    public void say_hello_jpascal() {
        String name = "Jean-Pascal";

        String result = greeterService.sayHello(name);

        assertThat("Not expected result", result, equalTo("Hello Jean-Pascal"));
    }

    @Test
    public void say_bye_jpascal() {
        String name = "Jean-Pascal";

        String result = greeterService.sayBye(name);

        assertThat("Not expected result", result, equalTo("Bye Jean-Pascal"));
    }

}
