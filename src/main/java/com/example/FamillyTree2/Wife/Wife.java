package com.example.FamillyTree2.Wife;

import com.example.FamillyTree2.Husband.Husband;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

import static org.apache.catalina.security.SecurityUtil.remove;

@Entity
public class Wife {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @OneToMany(mappedBy = "wife")
    private Set<Husband> husband;

    private String familyName;

    private String givenName;

    public Long getId() {
        return id;
    }

    public String getfamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String name) {
        this.givenName = name;
    }

    public Set<Husband> getHusband() {
        return this.husband;
    }


    }

