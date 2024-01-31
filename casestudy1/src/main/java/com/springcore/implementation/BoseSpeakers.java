package com.springcore.implementation;

import com.springcore.interfaces.Speakers;

public class BoseSpeakers implements Speakers {
    public String makeSound() {
        return "Playing music with BoseSpeakers";
    }
}
