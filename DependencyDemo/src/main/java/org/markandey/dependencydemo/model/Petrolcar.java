package org.markandey.dependencydemo.model;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary   //this will make the pterolcar bean primary
public class Petrolcar implements Car {

    @Override
    public void load() {
        System.out.println("petrol car starting");
    }
}
