package co.edu.unicauca.events.services;


import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicauca.events.dao.EventRepository;
import co.edu.unicauca.events.domain.Event;
import co.edu.unicauca.events.domain.Investigator;

@Service
public class EventService implements IEventService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    @Override
    public Event findById(Long id) {
        Optional<Event> eventOptional = eventRepository.findById(id);
        return eventOptional.orElse(null);
    }

    @Override
    public Event create(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Event update(Long id, Event event) {
        if (eventRepository.existsById(id)) {
            event.setId(id);
            return eventRepository.save(event);
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        eventRepository.deleteById(id);
    }

    @Override
    public Event save(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Set<Investigator> getProgramCommitteeByEventId(Long eventId) {
        Event event = findById(eventId);
        return event != null ? event.getProgramCommittee() : Collections.emptySet();
    }
}