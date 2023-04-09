package net.gukinon.learnJWT.controller;

import net.gukinon.learnJWT.model.Event;
import net.gukinon.learnJWT.model.FileEntity;
import net.gukinon.learnJWT.service.EventService;
import net.gukinon.learnJWT.service.FileService;
import net.gukinon.learnJWT.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/events")
public class EventControllerV1 {
    @Autowired
    EventService eventService;
    @Autowired
    FileService fileService;
    @Autowired
    UserService userService;
    @GetMapping
    public List<Event> getAllEvents(){
        return eventService.getAll();
    }
//    @PostMapping("add")
//    public Event addEvent(@RequestParam("user_id") int user_id,
//                          @RequestParam("file_id") int file_id) {
////        FileEntity
////        Event event = new Event();
////
////        eventService.create(event);
////
//    }
}
