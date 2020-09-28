package org.example.SpringBoot.WordCalculator;

import org.example.SpringBoot.Greeting;
import org.example.SpringBoot.Exception.CannotComputeException;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class PermutationController {
    private final AtomicLong counter = new AtomicLong();
    @PostMapping(path = "/permute", consumes = "application/json", produces = "application/json")
    public HashSet<String> permute(@RequestBody Permutation newPermuation)  {
    	try {
        return newPermuation.getWorldList();
    	}catch( CannotComputeException ex) {
    		System.out.println("Current implemantation is not able to produce permutation for string length greater than 9");
    		return new HashSet<String>();
    	}
    }
}
