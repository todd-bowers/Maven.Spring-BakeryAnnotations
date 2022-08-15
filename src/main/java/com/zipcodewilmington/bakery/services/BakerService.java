package com.zipcodewilmington.bakery.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.zipcodewilmington.bakery.models.Baker;
import com.zipcodewilmington.bakery.repositories.BakerRepository;

@Service
public class BakerService {
    @Autowired
    private BakerRepository repository;

    public BakerService(BakerRepository repository) {
        this.repository = repository;
    }

    public Iterable<Baker> index() {
        return repository.findAll();
    }

    @GetMapping()
    public Baker show(Long id) {
        return repository.findById(id).get();
    }

    @PutMapping
    public Baker create(Baker baker) {
        return repository.save(baker);
    }

    @PutMapping
    public Baker update(Long id, Baker newBakerData) {
        Baker originalBaker = repository.findById(id).get();
        originalBaker.setName(newBakerData.getName());
        originalBaker.setSpecialty(newBakerData.getSpecialty());
        return repository.save(originalBaker);
    }

    @DeleteMapping
    public Boolean delete(Long id) {
        repository.deleteById(id);
        return true;
    }
}
