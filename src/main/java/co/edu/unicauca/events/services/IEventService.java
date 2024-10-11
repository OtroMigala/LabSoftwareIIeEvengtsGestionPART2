package co.edu.unicauca.events.services;

import java.util.List;
import java.util.Set;

import co.edu.unicauca.events.domain.Event;
import co.edu.unicauca.events.domain.Investigator;

public interface IEventService { 
    public List<Event> findAll(); 
    public Event findById(Long id); 
    public Event create(Event event); 
    public Event update(Long id, Event event); 
    public void deleteById(Long id); 
    public Event save(Event event);
    Set<Investigator> getProgramCommitteeByEventId(Long id);
} 