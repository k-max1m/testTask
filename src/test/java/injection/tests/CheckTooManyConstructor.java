package injection.tests;

import injection.exceptions.TooManyConstructorsException;
import injection.injector.Injector;
import injection.injector.InjectorImpl;
import injection.provider.Provider;
import injection.resources.classForInject.EventDAO;
import injection.resources.classForInject.EventDaoImplOneConstructor;
import injection.resources.classForInject.EventDaoTwoConstructor;
import org.junit.Assert;
import org.junit.Test;

public class CheckTooManyConstructor {
    @Test(expected = TooManyConstructorsException.class)
    public void checkException() {
        Injector injector = new InjectorImpl();
        injector.bind(EventDAO.class, EventDaoTwoConstructor.class);
    }
}
