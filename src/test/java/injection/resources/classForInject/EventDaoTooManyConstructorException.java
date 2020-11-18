package injection.resources.classForInject;

import injection.annotation.Inject;

public class EventDaoTooManyConstructorException implements EventDAO {
    private Entity entity;

    @Inject
    public EventDaoTooManyConstructorException(Entity entity) {
        this.entity = entity;
    }

    @Inject
    public EventDaoTooManyConstructorException() {

    }
}
