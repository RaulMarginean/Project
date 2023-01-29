package com.example.FamillyTree2.Wife;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wife")
public class WifeController {

    @Autowired
    public WifeRepository wifeRepository;

    @GetMapping
    public List<Wife> getWife() {
        return wifeRepository.findAll();
    }

    @PostMapping
    public Wife createWife(@RequestBody Wife wife) {
        return wifeRepository.save(wife);
    }

}

