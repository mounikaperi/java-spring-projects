package com.springcore.implementation;

import com.springcore.interfaces.Tyres;
import org.springframework.stereotype.Component;


@Component
public class MichelinTyres implements Tyres {
    public String rotate() {
        return "Vehicle moving with MichelinTyres";
    }
}
