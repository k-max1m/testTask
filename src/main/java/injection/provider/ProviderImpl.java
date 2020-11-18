package injection.provider;

public class ProviderImpl<T> implements Provider<T> {
    private T obj;

    public ProviderImpl() {
    }

    public ProviderImpl(T obj) {
        this.obj = obj;
    }

    @Override
    public synchronized T getInstance() {
        return obj;
    }
}
