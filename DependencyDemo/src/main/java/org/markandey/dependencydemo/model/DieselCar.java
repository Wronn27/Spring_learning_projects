package org.markandey.dependencydemo.model;

import org.springframework.stereotype.Component;

@Component
public class DieselCar implements Car {

    @Override
    public void load() {
        System.out.println("Diesel car starting");
    }
}
