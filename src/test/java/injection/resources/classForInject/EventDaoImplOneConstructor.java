package injection.resources.classForInject;

import injection.annotation.Inject;

public class EventDaoImplOneConstructor implements EventDAO {
    private Entity entity;

    @Inject
    public EventDaoImplOneConstructor(Entity entity) {
        this.entity = entity;
    }

    public EventDaoImplOneConstructor() {

    }
}
