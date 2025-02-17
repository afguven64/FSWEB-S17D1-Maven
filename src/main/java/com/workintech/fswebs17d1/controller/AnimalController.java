package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "/workintech") // Bu sınıfta her mapin başına /workintech ekler
public class AnimalController {

    private Map<Integer, Animal> animals = new HashMap<>(){{
        animals.put(1, new Animal(1, "Cat"));
    }};

    @GetMapping("/animal")
    public Collection<Animal> getAnimals() {

        return animals.values();
    }

    @GetMapping("/animal/{id}")
    public Animal getAnimals(@PathVariable("id") Integer id) {
        return animals.get(id);
    }

    @PostMapping("/animal")
    public void postAnimals(@RequestBody Animal animal) {
        animals.put(animal.getId(), animal);
    }

    @PutMapping("/animal/{id}")
    public void putAnimals(@PathVariable("id")
                               Integer id, @RequestBody Animal animal) {
        if(!animals.containsKey(animal.getId())) {
            animals.put(animal.getId(), animal);
        }

    }

    @DeleteMapping("/animal/{id}")
    public void deleteAnimals(@PathVariable("id") Integer id) {
        if(animals.containsKey(id) && id!= null) {
            animals.remove(id);
        }
    }
}

