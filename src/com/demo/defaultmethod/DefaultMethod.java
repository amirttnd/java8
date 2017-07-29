package com.demo.defaultmethod;

interface Vehicle {
    default void run() {
        System.out.println("Run");
    }

    int getRatting();
}

class RenaultCar implements Vehicle {

    @Override
    public int getRatting() {
        return 4;
    }
}

public class DefaultMethod {

    public static void main(String[] args) {
        RenaultCar renaultCar = new RenaultCar();
        renaultCar.run();
        System.out.println(renaultCar.getRatting());
    }
}
