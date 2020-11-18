package injection.tests;

import injection.exceptions.TooManyConstructorsException;
import injection.injector.Injector;
import injection.injector.InjectorImpl;
import injection.resources.classForInject.EventDAO;
import injection.resources.classForInject.EventDaoTooManyConstructorException;
import org.junit.Test;

public class TooManyConstructorExceptionTest {
    @Test(expected = TooManyConstructorsException.class)
    public void checkException() {
        Injector injector = new InjectorImpl();
        injector.bind(EventDAO.class, EventDaoTooManyConstructorException.class);
    }
}
