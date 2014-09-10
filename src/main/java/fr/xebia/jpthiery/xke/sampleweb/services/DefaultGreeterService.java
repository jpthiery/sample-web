package fr.xebia.jpthiery.xke.sampleweb.services;

/**
 * Created by jpthiery on 10/09/2014.
 */
public class DefaultGreeterService implements GreeterService {

    public static final String HELLO_SENTENCE = "Hello %s";

    public static final String BYE_SENTENCE = "Bye %s";

    public DefaultGreeterService() {
        super();
    }

    @Override
    public String sayHello(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name can't be null.");
        }
        return String.format(HELLO_SENTENCE,name);
    }

    @Override
    public String sayBye(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name can't be null.");
        }
        return String.format(BYE_SENTENCE,name);
    }
}
