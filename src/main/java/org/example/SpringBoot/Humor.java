package org.example.SpringBoot;

import org.example.SpringBoot.WordCalculator.Sample;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

import java.util.Map;
@RestController
public class Humor {

    @GetMapping("/whoami")
    public String whomai() {
        return "You're are my master Pavan Kumar Tulasi";
    }

    @GetMapping("/whoareyou")
    public String whoareyou() {
        return  getRandomValue()+"Iam running on"+getComputerName();
    }
    public String getRandomValue(){
        String arr[] ={"Iam  Batman \n","Iam one punch man\n","Iam a bot but i would like to be called as JARVIS\n"};
        return arr[(int )(Math.random() * 2 + 0)];
    }
    @GetMapping("/")
    public Sample root(Sample sample) {
        //registry.addViewController("/").setViewName("redirect:/index.html");
        return  sample;
    }
    private static String getComputerName()
    {
        Map<String, String> env = System.getenv();
        if (env.containsKey("COMPUTERNAME"))
            return env.get("COMPUTERNAME");
        else if (env.containsKey("HOSTNAME"))
            return env.get("HOSTNAME");
        else
            return "Unknown Computer";
    }



}
