package com.antonromanov.springhibernate.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Test", schema = "public")
public class User implements Serializable {

        //final  char dm = (char) 34;
    //String sql = "INSERT INTO public." + dm + "Test" + dm + "  (id, name) VALUES (:id, :name)";

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name="name")
    private String name;


    public User(String name) {
       this.name = name;
    }

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

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phones=" + '}';
    }

}
