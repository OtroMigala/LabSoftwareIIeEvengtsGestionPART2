package co.edu.unicauca.events.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import co.edu.unicauca.events.domain.Chair;

@Repository
public interface ChairRepository extends JpaRepository<Chair, Long> {}