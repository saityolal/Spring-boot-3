package com.springboot.jpahibernate.course;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.stereotype.Component;

@Component
@Entity
public class course {
    @Id
    private int id;
    //@Column(name = "definition") // It has to correspond to that is in database
    private String definition;
    //@Column (name = "instructor")
    private String instructor;



    public course(int id, String definition, String instructor) {
        this.id = id;
        this.definition = definition;
        this.instructor = instructor;
    }
    public course(){}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "course{" +
                "id=" + id +
                ", definition='" + definition + '\'' +
                ", instructor='" + instructor + '\'' +
                '}';
    }
}
