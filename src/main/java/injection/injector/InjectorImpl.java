package injection.injector;

import injection.annotation.Inject;
import injection.exceptions.BindingNotFoundException;
import injection.exceptions.ConstructorNotFoundException;
import injection.exceptions.TooManyConstructorsException;
import injection.provider.Provider;
import injection.provider.ProviderImpl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InjectorImpl implements Injector {
    private final Map<Class<?>, Object> container;


    public InjectorImpl() {
        container = new HashMap<>();
    }

    @Override
    public synchronized <T> Provider<T> getProvider(Class<T> type) {
        return new ProviderImpl<>((T) container.get(type));
    }

    @Override
    public synchronized <T> void bind(Class<T> intf, Class<? extends T> impl) {
        List<Constructor<?>> annotatedConstructor = Arrays.stream(impl.getConstructors())
                .filter(o -> o.isAnnotationPresent(Inject.class))
                .collect(Collectors.toList());

        if (annotatedConstructor.size() > 1) {
            throw new TooManyConstructorsException();
        } else if (annotatedConstructor.size() == 0) {
            try {
                container.put(intf, impl.getDeclaredConstructor().newInstance());
            } catch (NoSuchMethodException e) {
                throw new ConstructorNotFoundException();
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        } else {
            Object[] objects = Arrays.stream(annotatedConstructor.get(0).getParameterTypes()).map(o -> {
                try {
                    return o.getDeclaredConstructor().newInstance();
                } catch (NoSuchMethodException e) {
                    throw new BindingNotFoundException();
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
                return null;
            }).toArray();

            try {
                container.put(intf, annotatedConstructor.get(0).newInstance(objects));
            } catch (InstantiationException | InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public synchronized <T> void bindSingleton(Class<T> intf, Class<? extends T> impl) {
        if (!container.containsKey(intf)) {
            bind(intf, impl);
        }
    }
}
