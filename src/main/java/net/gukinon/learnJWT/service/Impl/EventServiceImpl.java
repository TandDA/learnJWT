package net.gukinon.learnJWT.service.Impl;

import net.gukinon.learnJWT.model.Event;
import net.gukinon.learnJWT.repository.EventRepository;
import net.gukinon.learnJWT.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EventServiceImpl implements EventService {
    @Autowired
    EventRepository eventRepository;

    @Override
    public List<Event> getAll() {
        return eventRepository.findAll();
    }

    @Override
    public Event create(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Event findById(Integer id) {
        return eventRepository.findById(id).get();
    }

    @Override
    public void deleteById(Integer id) {
        eventRepository.deleteById(id);
    }
}
