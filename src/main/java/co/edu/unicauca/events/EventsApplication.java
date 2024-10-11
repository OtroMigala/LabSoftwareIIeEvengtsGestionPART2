package co.edu.unicauca.events;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("co.edu.unicauca.events.domain")
@EnableJpaRepositories("co.edu.unicauca.events.dao")
public class EventsApplication {
    public static void main(String[] args) {
        SpringApplication.run(EventsApplication.class, args);
    }
}