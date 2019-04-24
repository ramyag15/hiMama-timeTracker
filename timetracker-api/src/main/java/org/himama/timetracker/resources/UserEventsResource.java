package org.himama.timetracker.resources;

import org.himama.timetracker.data.*;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserEventsResource {

    private List<UserEventsResponse> allUserEvents;

    public UserEventsResource(UserEventsInterface userEventsInterface,
                              UsersInterface usersInterface,
                              EventsInterface eventsInterface) {
        this.allUserEvents = packageUserEvents(userEventsInterface.findAll(), usersInterface, eventsInterface);
    }

    public UserEventsResource(Long id, UserEventsInterface userEventsInterface,
                              UsersInterface usersInterface,
                              EventsInterface eventsInterface, String action) {

        if (action.compareTo("get") == 0) {
            UserEvents userEvents = userEventsInterface.findOne(id);
            this.allUserEvents = packageUserEvents(Collections.singleton(userEvents), usersInterface, eventsInterface);
        } else if (action.compareTo("delete") == 0) {
            userEventsInterface.delete(id);
        }
    }

    public UserEventsResource(NewUserEvent newUserEvent,
                              UserEventsInterface userEventsInterface,
                              UsersInterface usersInterface,
                              EventsInterface eventsInterface) {

        Users user = null;
        Long userId = usersInterface.getUserIdByUName(newUserEvent.getUserName());

        if (userId != null) {
            user = usersInterface.findOne(userId);
        } else {
            user = new Users(newUserEvent.getUserName());
            user = usersInterface.save(user);
        }

        UserEvents userEvents = new UserEvents(user.getId(),
                eventsInterface.getEventIdByType(newUserEvent.getEventType().name()));
        userEventsInterface.save(userEvents);
        this.allUserEvents = packageUserEvents(userEventsInterface.findAll(), usersInterface, eventsInterface);
    }

    public List<UserEventsResponse> getAllUserEvents() {
        return this.allUserEvents;
    }

    public List<UserEventsResponse> packageUserEvents(Iterable<UserEvents> userEvents, UsersInterface usersInterface,
                                                      EventsInterface eventsInterface) {
        List<UserEventsResponse> userEventsResponses = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        for(UserEvents userEvent: userEvents) {
            Users user = usersInterface.findOne(userEvent.getUserId());
            UserEventsResponse userEventsResponse = new UserEventsResponse(user.getUsername(),
                    user.getId(),
                    eventsInterface.getEventTypeById(userEvent.getEventId()),
                    userEvent.getEventTime().format(formatter), userEvent.getId());
            userEventsResponses.add(userEventsResponse);
        }

        return userEventsResponses;
    }
}
