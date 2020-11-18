package injection.resources.classForInject;

import injection.annotation.Inject;

public class EventDaoBindingException implements EventDAO {
    @Inject
    public EventDaoBindingException(EventDAO eventDAO) {
    }
}
