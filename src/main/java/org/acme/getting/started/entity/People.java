package org.acme.getting.started.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;

@Entity
public class People extends PanacheEntity {
    public String name;
    public String surname;
    public Long age;

    public String toString() {
        return name + " " + surname + ", " + age + " years old";
    }
}
