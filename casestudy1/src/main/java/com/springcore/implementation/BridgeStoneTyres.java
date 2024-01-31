package com.springcore.implementation;

import com.springcore.interfaces.Tyres;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class BridgeStoneTyres implements Tyres {

    public String rotate() {
        return "Vehicle moving with BridgeStoneTyres";
    }
}
