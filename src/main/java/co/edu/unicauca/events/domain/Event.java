package co.edu.unicauca.events.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "events")
public class Event implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToOne
    private Chair chair;

    @OneToMany
    private Set<Investigator> programCommittee = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // other fields and methods

    public Chair getChair() {
        return chair;
    }

    public void setChair(Chair chair) {
        this.chair = chair;
    }

    public Set<Investigator> getProgramCommittee() {
        return programCommittee;
    }

    public void setProgramCommittee(Set<Investigator> programCommittee) {
        this.programCommittee = programCommittee;
    }
}
