package com.example.FamillyTree2.Child;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/children")
public class ChildController {

    @Autowired
   ChildRepository childRepository;

    @GetMapping
    public List<Child> getChild() {
        return childRepository.findAll();
    }
    @PostMapping
    public Child createChild(@RequestBody Child child) {
        return childRepository.save(child);
    }
}