package com.example.FamillyTree2.Husband;

import com.example.FamillyTree2.Child.Child;
import com.example.FamillyTree2.Child.ChildController;
import com.example.FamillyTree2.Child.ChildRepository;
import com.example.FamillyTree2.Wife.Wife;
import com.example.FamillyTree2.Wife.WifeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/husband")
public class HusbandController {

    @Autowired
    HusbandRepository husbandRepository;

    @Autowired
    ChildRepository childRepository;

    @Autowired
    WifeRepository wifeRepository;

    @GetMapping
    List<Husband> getHusband() {
        return husbandRepository.findAll();
    }

    @PostMapping
    Husband createHusband(@RequestBody Husband husband) {
        return husbandRepository.save(husband);
    }

    @PutMapping("/{husbandId}/children/{childId}")
    public  Husband addChildToFather(
           @PathVariable Long husbandId,
            @PathVariable Long childId
    ) {
        Husband husband = husbandRepository.findById(husbandId).get();
        Child child = childRepository.findById(childId).get();
        husband.children.add(child);
        return husbandRepository.save(husband);
    }

    @PutMapping("/{husbandId}/wife/{wifeId}")
    Husband assignWifeToHusband(
            @PathVariable Long husbandId,
            @PathVariable Long wifeId
    ) {
        Husband husband = husbandRepository.findById(husbandId).get();
        Wife wife = wifeRepository.findById(wifeId).get();
        husband.setWife(wife);
        return husbandRepository.save(husband);
    }
}
