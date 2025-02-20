package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(path = "/workintech/animal") // Bu sınıfta her mapin başına /workintech ekler
public class AnimalController {

    private Map<Integer, Animal> animals = new HashMap<>();

    @GetMapping("")
    public List<Animal> getAnimals() {

        return new ArrayList<>(animals.values());
    }

    @GetMapping("/{id}")
    public Animal getAnimals(@PathVariable("id") Integer id) {
        return animals.get(id);
    }

    @PostMapping("")
    public void postAnimals(@RequestBody Animal animal) {
        animals.put(animal.getId(), animal);
    }

    @PutMapping("/{id}")
    public void putAnimals(@PathVariable("id")
                               Integer id, @RequestBody Animal animal) {
        if(!animals.containsKey(animal.getId())) {
            animals.put(animal.getId(), animal);
        }

    }

    @DeleteMapping("/{id}")
    public void deleteAnimals(@PathVariable("id") Integer id) {
        if(animals.containsKey(id) && id!= null) {
            animals.remove(id);
        }
    }
}

