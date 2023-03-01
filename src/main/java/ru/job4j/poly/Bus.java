package ru.job4j.poly;

public class Bus implements Transport {
    public void drive() {
        System.out.println("we are going");
    }

    public void passengers(int number) {
        System.out.println("we have " +  number + "passengers");
    }

    public double refuel(double quantity) {
        double pricePerGallon = 1.22;
        return quantity * pricePerGallon;
    }
}
