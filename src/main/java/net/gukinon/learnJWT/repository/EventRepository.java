package net.gukinon.learnJWT.repository;

import net.gukinon.learnJWT.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Integer> {
}
