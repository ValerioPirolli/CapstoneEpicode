package com.SpringBoot_SpringSecurity.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBoot_SpringSecurity.models.Actors;
import com.SpringBoot_SpringSecurity.models.Movies;
import com.SpringBoot_SpringSecurity.services.ActorService;

@RestController
@RequestMapping("/api/actor")
public class ActorController {
    private ActorService ar;

    @Autowired
    public ActorController(ActorService Service) {
        this.ar = Service;
    }

    @GetMapping("/all")
    public List<Actors> getAllProducts() {
        System.out.println("Chiamata attori riuscita");
        return ar.findAll();
    }
    @GetMapping("/{id}")
    public Actors getActorById(@PathVariable Long id) {
        return ar.findById(id);
    }
    @GetMapping("/{id}/movies")
    public Set<Movies> getActorMovies(@PathVariable Long id) {
        Actors actor = ar.findById(id);
        Set<Movies> a = new HashSet<Movies>(actor.getFilms());
        return a;
    }
    @GetMapping("/name/{name}")
    public Movies getMovieByName(@PathVariable String name) {
        return ar.findByName(name);
    }
    
}