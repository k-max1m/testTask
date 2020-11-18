package injection.tests;

import injection.exceptions.ConstructorNotFoundException;
import injection.injector.Injector;
import injection.injector.InjectorImpl;
import injection.resources.classForInject.EventDAO;
import injection.resources.classForInject.EventDaoConstructorNotFoundException;
import org.junit.Test;

public class ConstructorNotFoundExceptionTest {
    @Test(expected = ConstructorNotFoundException.class)
    public void checkException() {
        Injector injector = new InjectorImpl();
        injector.bind(EventDAO.class, EventDaoConstructorNotFoundException.class);
    }
}
