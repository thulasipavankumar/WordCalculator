package org.example.SpringBoot.WordCalculator;

import org.example.SpringBoot.Greeting;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;
@RestController
public class SearchWordController {

    private final AtomicLong counter = new AtomicLong();
    @PostMapping(path = "/isDictionaryWord", consumes = "application/json", produces = "application/json")
    public boolean isDictionaryWord(@RequestBody SearchWord obj) {
        return  obj.isDictionaryWord();
    }
}
