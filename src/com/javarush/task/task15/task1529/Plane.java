package com.javarush.task.task15.task1529;

public class Plane implements CanFly {
    public int countPassengers;

    public Plane(int countPassengers){
        this.countPassengers=countPassengers;
    }

    @Override
    public void fly() {

    }
}
