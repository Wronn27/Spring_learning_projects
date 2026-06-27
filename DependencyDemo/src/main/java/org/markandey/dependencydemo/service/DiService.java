package org.markandey.dependencydemo.service;

import org.markandey.dependencydemo.model.Car;
import org.springframework.stereotype.Service;


@Service
public class DiService {
    private final Car car;

    public DiService(Car car) {    // if i dont specify @primary then i can use @Qualifier inside the constructor argument as
                                   //  public DiService(@Qualifier("dieselcar") Car car)
        this.car=car;
    }

    public void compile(){
        car.load();
    }
}
