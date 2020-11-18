package injection.tests;

import injection.injector.Injector;
import injection.injector.InjectorImpl;
import injection.provider.Provider;
import injection.resources.classForInject.EventDAO;
import injection.resources.classForInject.EventDaoOneDefaultConstructor;
import injection.resources.classForInject.EventDaoOneInjectConstructor;
import org.junit.Assert;
import org.junit.Test;

public class OneInjectConstructorTest {
    @Test
    public void checkOneConstructor() {
        Injector injector = new InjectorImpl();
        injector.bind(EventDAO.class, EventDaoOneInjectConstructor.class);

        Provider<EventDAO> provider = injector.getProvider(EventDAO.class);

        Assert.assertNotNull(provider);
        Assert.assertNotNull(provider.getInstance());
        Assert.assertSame(EventDaoOneInjectConstructor.class, provider.getInstance().getClass());
    }

    @Test
    public void checkOneSingleton() {
        Injector injector = new InjectorImpl();
        injector.bindSingleton(EventDAO.class, EventDaoOneInjectConstructor.class);
        Provider<EventDAO> provider = injector.getProvider(EventDAO.class);
        injector.bindSingleton(EventDAO.class, EventDaoOneInjectConstructor.class);
        Provider<EventDAO> provider2 = injector.getProvider(EventDAO.class);

        Assert.assertEquals(provider.getInstance(), provider2.getInstance());

    }

    @Test
    public void checkOdeDefault() {
        Injector injector = new InjectorImpl();
        injector.bind(EventDAO.class, EventDaoOneDefaultConstructor.class);

        Provider<EventDAO> provider = injector.getProvider(EventDAO.class);

        Assert.assertNotNull(provider);
        Assert.assertNotNull(provider.getInstance());
        Assert.assertSame(EventDaoOneDefaultConstructor.class, provider.getInstance().getClass());
    }
}
