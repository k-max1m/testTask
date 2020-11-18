package injection.resources.classForInject;

import injection.annotation.Inject;

public class EventDaoTwoConstructor implements EventDAO {
    private Entity entity;

    @Inject
    public EventDaoTwoConstructor(Entity entity) {
        this.entity = entity;
    }

    @Inject
    public EventDaoTwoConstructor() {

    }
}
