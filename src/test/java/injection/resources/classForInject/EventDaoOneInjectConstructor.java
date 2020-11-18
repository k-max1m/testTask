package injection.resources.classForInject;

import injection.annotation.Inject;

public class EventDaoOneInjectConstructor implements EventDAO {
    private Entity entity;

    @Inject
    public EventDaoOneInjectConstructor(Entity entity) {
        this.entity = entity;
    }

    public EventDaoOneInjectConstructor() {

    }
}
