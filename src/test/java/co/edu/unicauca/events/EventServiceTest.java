package co.edu.unicauca.events;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
    void testFindById() {
        // Arrange
        Long eventId = 1L;
        Event event = new Event();
        event.setId(eventId);
        event.setName("Conferencia de IA 2025");
        
        when(eventRepository.findById(eventId)).thenReturn(Optional.of(event));

        // Act
        Event result = eventService.findById(eventId);

        // Assert
        assertNotNull(result);
        assertEquals(eventId, result.getId());
        assertEquals("Conferencia de IA 2025", result.getName());
        verify(eventRepository).findById(eventId);
    }

    @Test
    void testGetProgramCommitteeByEventId() {
        // Arrange
        Long eventId = 1L;
        Event event = new Event();
        event.setId(eventId);
        Set<Investigator> committee = new HashSet<>();
        committee.add(new Investigator("Dra. Ada Lovelace"));
        committee.add(new Investigator("Dr. John von Neumann"));
        event.setProgramCommittee(committee);

        when(eventRepository.findById(eventId)).thenReturn(Optional.of(event));

        // Act
        Set<Investigator> result = eventService.getProgramCommitteeByEventId(eventId);

        // Assert
        assertEquals(2, result.size());
        assertTrue(result.stream().anyMatch(i -> i.getName().equals("Dra. Ada Lovelace")));
        assertTrue(result.stream().anyMatch(i -> i.getName().equals("Dr. John von Neumann")));
        verify(eventRepository).findById(eventId);
    }
}