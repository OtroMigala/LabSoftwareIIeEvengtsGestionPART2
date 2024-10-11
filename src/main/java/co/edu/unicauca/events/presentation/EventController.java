package co.edu.unicauca.events.presentation;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.events.domain.Event;
import co.edu.unicauca.events.domain.Investigator;
import co.edu.unicauca.events.services.IEventService;


@RestController 
@Component  
@RequestMapping("/events") 
public class EventController { 
    @Autowired 
    IEventService eventService; 

    @GetMapping
    public List<Event> findAll() { 
        return eventService.findAll(); 
    }
    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        Event createdEvent = eventService.create(event);
        return ResponseEntity.ok(createdEvent);
    }

    @GetMapping("/{id}") 
    public Event getEventById(@PathVariable Long id) { 
        return eventService.findById(id); 
    }
        @GetMapping("/{id}/committee")
    public Set<Investigator> getProgramCommittee(@PathVariable Long id) {
        return eventService.getProgramCommitteeByEventId(id);
    }
}
