package com.example.herokudemo.controller;

import com.example.herokudemo.entity.Example;
import com.example.herokudemo.repository.ExampleRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class ExampleController {

    private final ExampleRepository exampleRepository;

    @GetMapping("/examples")
    public List<Example> findAll() {
        return exampleRepository.findAll();
    }

    @GetMapping("/examples/{id}")
    public Example findById(@PathVariable("id") Long id) {
        return exampleRepository.findById(id).orElse(null);
    }

    @PostMapping("/examples")
    public Example create(@RequestParam("name") String name) {
        return exampleRepository.save(
                Example.builder().name(name).build()
        );
    }
}
