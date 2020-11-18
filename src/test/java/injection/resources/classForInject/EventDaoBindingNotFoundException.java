package injection.resources.classForInject;

import injection.annotation.Inject;

public class EventDaoBindingNotFoundException implements EventDAO {
    @Inject
    public EventDaoBindingNotFoundException(EventDAO eventDAO) {
    }
}
