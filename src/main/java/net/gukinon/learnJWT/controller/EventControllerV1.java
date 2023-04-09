package net.gukinon.learnJWT.controller;

import net.gukinon.learnJWT.dto.EventDto;
import net.gukinon.learnJWT.model.Event;
import net.gukinon.learnJWT.model.FileEntity;
import net.gukinon.learnJWT.model.Status;
import net.gukinon.learnJWT.model.UserEntity;
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
    @GetMapping("/{id}")
    public Event getEventById(@PathVariable int id){
        return eventService.findById(id);
    }
    @PostMapping("add")
    public Event addEvent(@RequestBody EventDto eventDto) {
        Event event = new Event();
        FileEntity fileEntity = fileService.findById(eventDto.getFile_id());
        UserEntity userEntity = userService.findById(eventDto.getUser_id());
        event.setFile(fileEntity);
        event.setUserEntity(userEntity);
        event.setStatus(Status.ACTIVE);
        return eventService.create(event);
    }
    @DeleteMapping("delete/{id}")
    public void deleteEventById(@PathVariable int id){
        eventService.deleteById(id);
    }
}
