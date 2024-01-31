package com.springcore.implementation;

import com.springcore.interfaces.Speakers;

public class SonySpeakers implements Speakers {
    public String makeSound() {
        return "Playing music with SonySpeakers";
    }
}
