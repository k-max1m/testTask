package injection.tests;

import injection.exceptions.BindingNotFoundException;
import injection.injector.Injector;
import injection.injector.InjectorImpl;
import injection.resources.classForInject.EventDAO;
import injection.resources.classForInject.EventDaoBindingException;
import injection.resources.classForInject.EventDaoTwoConstructor;
import org.junit.Test;

public class CheckBindingException {
    @Test(expected = BindingNotFoundException.class)
    public void checkException() {
        Injector injector = new InjectorImpl();
        injector.bind(EventDAO.class, EventDaoBindingException.class);
    }
}
