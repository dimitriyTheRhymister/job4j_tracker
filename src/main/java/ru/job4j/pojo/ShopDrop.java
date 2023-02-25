package ru.job4j.pojo;

public class ShopDrop {
    public static Product[] delete(Product[] products, int index) {
        for (int i = index; i < products.length - 1; i++) {
            products[i] = products[i + 1];
            products[i + 1] = null;
            String p = products[i].getName();
            System.out.println(p);
        }
        return products;
    }
}