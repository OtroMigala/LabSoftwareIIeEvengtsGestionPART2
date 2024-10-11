package co.edu.unicauca.events;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import co.edu.unicauca.events.dao.EventRepository;
import co.edu.unicauca.events.domain.Event;
import co.edu.unicauca.events.domain.Investigator;
import co.edu.unicauca.events.services.EventService;

@ExtendWith(MockitoExtension.class)
class EventServiceTest {

    @Mock
    private EventRepository eventRepository;

    @InjectMocks
    private EventService eventService;

    @Test
    void testGetProgramCommitteeByEventId() {
        Event event = new Event();
        event.setId(1L);
        Set<Investigator> committee = new HashSet<>();
        committee.add(new Investigator());
        event.setProgramCommittee(committee);

        when(eventRepository.findById(1L)).thenReturn(Optional.of(event));

        Set<Investigator> result = eventService.getProgramCommitteeByEventId(1L);

        assertEquals(1, result.size());
        verify(eventRepository).findById(1L);
    }
}