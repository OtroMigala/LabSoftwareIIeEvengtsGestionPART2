package co.edu.unicauca.events.services;


import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicauca.events.dao.ChairRepository;
import co.edu.unicauca.events.dao.EventRepository;
import co.edu.unicauca.events.dao.InvestigatorRepository;
import co.edu.unicauca.events.domain.Chair;
import co.edu.unicauca.events.domain.Event;
import co.edu.unicauca.events.domain.Investigator;

@Service
public class EventService implements IEventService {

    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private ChairRepository chairRepository;
    @Autowired
    private InvestigatorRepository investigatorRepository;

    @Override
    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    @Override
    public Event findById(Long id) {
        // Mensaje a EventRepository: Llamada al método findById
        Optional<Event> eventOptional = eventRepository.findById(id);
        
        // Devolución del objeto Event o null
        return eventOptional.orElse(null);
    }

    @Override

    public Event create(Event event) {
        if (event.getChair() != null) {
            Chair chair = chairRepository.save(event.getChair());
            event.setChair(chair);
        }
        if (event.getProgramCommittee() != null) {
            Set<Investigator> savedInvestigators = event.getProgramCommittee().stream()
                .map(investigatorRepository::save)
                .collect(Collectors.toSet());
            event.setProgramCommittee(savedInvestigators);
        }
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
        // Mensaje a EventService: Llamada al método findById
        Event event = findById(eventId);
        
        // Mensaje a Event: Llamada al método getProgramCommittee
        return event != null ? event.getProgramCommittee() : Collections.emptySet();
    }

    
    
}