package com.example.FamillyTree2.Husband;

import com.example.FamillyTree2.Child.Child;
import com.example.FamillyTree2.Wife.Wife;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Husband {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String familyName;
    private String givenName;

    @ManyToMany
    @JoinTable(
            name = "childs_father",
            joinColumns = @JoinColumn(name = "husband_id"),
            inverseJoinColumns = @JoinColumn(name = "child_id")
    )
    Set<Child> children = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "wife_id", referencedColumnName = "id")
    private Wife wife;

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

    public Set<Child> getChildren() {
        return children ;

    }
        public Wife getWife(){
        return wife;
        }
        public void setWife(Wife wife) {
        this.wife = wife;
    }


}

