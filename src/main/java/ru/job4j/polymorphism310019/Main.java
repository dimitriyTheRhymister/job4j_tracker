package ru.job4j.polymorphism310019;

public class Main {
    public static void main(String[] args) {
        Vehicle p = new Plane("Boeing");
        Vehicle t = new Train("Shinkansen");
        Vehicle b = new Bus("Mercedes-Benz Travego");
        Vehicle p2 = new Plane("Airbus");
        Vehicle t2 = new Train("TGV POS");
        Vehicle b2 = new Bus("Neoplan N5218 SHD Starliner");
        Vehicle p3 = new Plane("Tu-154");
        Vehicle t3 = new Train("Sapsan");
        Vehicle b3 = new Bus("Ikarus-386");
        Vehicle[] vehicles = new Vehicle[]{p, t, b, p2, t2, b2, p3, t3, b3};
        for (int i = 0; i < vehicles.length; i++) {
            if (i % 3 == 0) {
                vehicles[i].modern();
            }
            vehicles[i].move();
        }
    }
}
