package injection.tests;

import injection.injector.Injector;
import injection.injector.InjectorImpl;
import injection.provider.Provider;
import injection.resources.classForInject.EventDAO;
import injection.resources.classForInject.EventDaoDefaultConstructor;
import injection.resources.classForInject.EventDaoImplOneConstructor;
import org.junit.Assert;
import org.junit.Test;

public class CheckOneInjectConstructor {
    @Test
    public void checkOneConstructor() {
        Injector injector = new InjectorImpl();
        injector.bind(EventDAO.class, EventDaoImplOneConstructor.class);

        Provider<EventDAO> provider = injector.getProvider(EventDAO.class);

        Assert.assertNotNull(provider);
        Assert.assertNotNull(provider.getInstance());
        Assert.assertSame(EventDaoImplOneConstructor.class, provider.getInstance().getClass());
    }

    @Test
    public void checkOneSingleton() {
        Injector injector = new InjectorImpl();
        injector.bindSingleton(EventDAO.class, EventDaoImplOneConstructor.class);
        Provider<EventDAO> provider = injector.getProvider(EventDAO.class);
        injector.bindSingleton(EventDAO.class, EventDaoImplOneConstructor.class);
        Provider<EventDAO> provider2 = injector.getProvider(EventDAO.class);

        Assert.assertEquals(provider.getInstance(), provider2.getInstance());

    }

    @Test
    public void checkOdeDefault() {
        Injector injector = new InjectorImpl();
        injector.bind(EventDAO.class, EventDaoDefaultConstructor.class);

        Provider<EventDAO> provider = injector.getProvider(EventDAO.class);

        Assert.assertNotNull(provider);
        Assert.assertNotNull(provider.getInstance());
        Assert.assertSame(EventDaoDefaultConstructor.class, provider.getInstance().getClass());
    }
}
