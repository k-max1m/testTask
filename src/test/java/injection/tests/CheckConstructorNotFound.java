package injection.tests;

import injection.exceptions.ConstructorNotFoundException;
import injection.injector.Injector;
import injection.injector.InjectorImpl;
import injection.resources.classForInject.EventDAO;
import injection.resources.classForInject.EventDaoConstructorNotFound;
import injection.resources.classForInject.EventDaoTwoConstructor;
import org.junit.Test;

public class CheckConstructorNotFound {
    @Test(expected = ConstructorNotFoundException.class)
    public void checkException() {
        Injector injector = new InjectorImpl();
        injector.bind(EventDAO.class, EventDaoConstructorNotFound.class);
    }
}
