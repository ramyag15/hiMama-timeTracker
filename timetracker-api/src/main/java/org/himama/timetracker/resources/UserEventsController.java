package org.himama.timetracker.resources;


import org.himama.timetracker.data.EventsInterface;
import org.himama.timetracker.data.NewUserEvent;
import org.himama.timetracker.data.UserEventsInterface;
import org.himama.timetracker.data.UsersInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserEventsController {
    @Autowired
    UsersInterface usersInterface;

    @Autowired
    EventsInterface eventsInterface;

    @Autowired
    UserEventsInterface userEventsInterface;

    @CrossOrigin()
    @RequestMapping("/user_events")
    public UserEventsResource userEvents() {
        return new UserEventsResource(userEventsInterface, usersInterface, eventsInterface);
    }

    @CrossOrigin()
    @RequestMapping(path="/new_user_event", method= RequestMethod.POST)
    public UserEventsResource userEvents(@RequestBody NewUserEvent newUserEvent) {
        return new UserEventsResource(newUserEvent, userEventsInterface, usersInterface, eventsInterface);
    }

    @CrossOrigin
    @RequestMapping(path="/user_event/{id}", method=RequestMethod.GET)
    public UserEventsResource getUserEvent(@PathVariable("id") Long id) {
        return new UserEventsResource(id, userEventsInterface, usersInterface, eventsInterface, "get");
    }

    @CrossOrigin
    @RequestMapping(path="/user_event/{id}", method=RequestMethod.DELETE)
    public UserEventsResource deleteuserEvent(@PathVariable("id") Long id) {
        return new UserEventsResource(id, userEventsInterface, usersInterface, eventsInterface, "delete");
    }
}
