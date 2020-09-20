package org.example.SpringBoot.WordCalculator;

import org.example.SpringBoot.Greeting;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class PermutationController {
    private final AtomicLong counter = new AtomicLong();
    @PostMapping(path = "/permute", consumes = "application/json", produces = "application/json")
    public HashSet<String> permute(@RequestBody Permutation newPermuation) {
        return newPermuation.getWorldList();
    }
}
