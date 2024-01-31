package com.springcore.implementation;

import com.springcore.interfaces.Speakers;
import org.springframework.stereotype.Component;

@Component
public class BoseSpeakers implements Speakers {
    public String makeSound() {
        return "Playing music with BoseSpeakers";
    }
}
