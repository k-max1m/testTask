package injection.tests;

import injection.exceptions.BindingNotFoundException;
import injection.injector.Injector;
import injection.injector.InjectorImpl;
import injection.resources.classForInject.EventDAO;
import injection.resources.classForInject.EventDaoBindingNotFoundException;
import org.junit.Test;

public class BindingNotFoundExceptionTest {
    @Test(expected = BindingNotFoundException.class)
    public void checkException() {
        Injector injector = new InjectorImpl();
        injector.bind(EventDAO.class, EventDaoBindingNotFoundException.class);
    }
}
