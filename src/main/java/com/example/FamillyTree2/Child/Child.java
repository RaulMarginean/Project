package com.example.FamillyTree2.Child;

import com.example.FamillyTree2.Husband.Husband;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Child {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String familyName;
    private String givenName;

    @JsonIgnore
    @ManyToMany(mappedBy = "children")
    private Set<Husband> husband = new HashSet<>();

    public Long getId() {
        return id;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String name) {
        this.familyName = name;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String name) {
        this.givenName = name;
    }

    public Set<Husband> getHusband() {
        return husband;
    }

}

